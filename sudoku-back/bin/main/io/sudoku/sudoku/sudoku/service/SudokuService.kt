package io.sudoku.sudoku.sudoku.service

import io.sudoku.sudoku.sudoku.model.Sudoku
import io.sudoku.sudoku.sudoku.model.SudokuRequest

interface SudokuService {
    fun getRandomMap(sudokuRequest: SudokuRequest): Sudoku
}