import React, {useState, useEffect} from 'react';
import "./App.scss";
import {fetchSudoku} from "./api/sudoku";

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
                setLoading(true);

                const response = await fetchSudoku({params: {showCount: {rand}}});
                setBoard(response.data.map);
            } catch (e) {
                setError(e);
            } finally {
                setLoading(false);
            }
        };

        fetchArr();
    }, []);

    if (loading) return <div>로딩중..</div>;
    if (error) return <div>{error}</div>;
    // 연습
    if (!arrs) return null;

    return (<>
        <div className="sdk">
            {arrs.map(arr => ({arr}))}
        </div>
    </>);
}

export default App;
