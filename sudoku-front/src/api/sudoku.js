import api from "./api"

export function fetchSudoku({params}) {
    // 수정필요 - 주소
    return api.get(`/sudoku/random`, {
        params
        // 수정필요
    });
}

export function setBoard() {

}
