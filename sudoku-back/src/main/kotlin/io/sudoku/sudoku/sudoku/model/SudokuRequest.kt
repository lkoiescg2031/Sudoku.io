package io.sudoku.sudoku.sudoku.model

import org.hibernate.validator.constraints.Range

class SudokuRequest(
        @Range(min = 18, max = 81) val showCount: Int,
        val seed: Long?
)