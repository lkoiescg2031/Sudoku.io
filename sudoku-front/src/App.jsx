import React, { useState, useEffect } from 'react';
import axios from 'axios';
import "./App.scss";

function random(min, max) {
	return Math.floor(Math.random() * (max - min + 1)) + min;
}

function App() {
	// 만들 변수 및 변수 세팅할 때 useState사용
	const [loading, setLoading] = useState(null);
	const [error, setError] = useState(null);
	const [arrs, setArrs] = useState(null);

	useEffect(() => {
		const fetchArr = async () => {
			try {
				const rand = random(18, 81);

				setError(null);
				setArrs(null);
				setLoading(null);
				const response = await axios.get(
					`http://localhost:8080/api/v1/sudoku/random?showCount=${rand}`
				);
				setArrs(response.data);
				
			} catch (e) {
				console.log(e);
				setError(e);
			}
			setLoading(false);
		};
		fetchArr();
	  }, []);
	
	if (loading) return <div>로딩중..</div>;
	if (error) return <div>{error}</div>;
	// 연습
	if (!arrs) return null;
	console.log(arrs)
	
	return (
		<>
			{/* {JSON.stringify(arrs)} */}
			<div className="sdk">
				{arrs.map.map(arr => (
					{arr}
				))}
			</div>
		</>
	);
}

export default App;
