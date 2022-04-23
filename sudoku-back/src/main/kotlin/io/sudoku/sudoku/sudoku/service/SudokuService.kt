package io.sudoku.sudoku.sudoku.service

import io.sudoku.sudoku.board.model.Board
import io.sudoku.sudoku.sudoku.model.Sudoku
import io.sudoku.sudoku.sudoku.model.SudokuRequest

interface SudokuService {
    fun createRandomSudoku(sudokuRequest: SudokuRequest): Sudoku
    fun updateCorrectSudoku(sudoku: String, answer: Board): Sudoku
}