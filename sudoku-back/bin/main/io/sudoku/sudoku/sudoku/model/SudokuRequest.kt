package io.sudoku.sudoku.sudoku.model

import org.hibernate.validator.constraints.Range

data class SudokuRequest(

        val seed: Long? = null,

        @Range(min = 18, max = 81) val showCount: Int,
)
