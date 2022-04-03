package io.sudoku.sudoku.sudoku.service

import io.sudoku.sudoku.board.model.Board
import io.sudoku.sudoku.sudoku.model.Sudoku

interface SudokuService {
    fun createRandomSudoku(seed: Long?, showCount: Int): Sudoku
    fun updateCorrectSudoku(sudoku: String, answer: Board): Sudoku
}