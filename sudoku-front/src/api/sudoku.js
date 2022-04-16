import api from "./api"

export function fetchSudoku({params}) {
    return api.get(`/sudoku/random`, {
        params
    });
}

export function setBoard() {

}
