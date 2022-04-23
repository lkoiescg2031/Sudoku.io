import api from "./api";

export function fetchSudoku({ params }) {
	return api.post(`/games/random`, params);
}

export function setBoard() {}
