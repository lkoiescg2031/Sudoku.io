package io.sudoku.sudoku.sudoku.mapper

import io.sudoku.sudoku.sudoku.model.Sudoku
import org.apache.ibatis.annotations.Mapper

@Mapper
interface SudokuMapper {
    fun selectSudoku(gameId: String): Sudoku
    fun insertSudoku(sudoku: Sudoku)
    fun updateSudoku(sudoku: Sudoku)
}
