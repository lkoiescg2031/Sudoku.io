package io.sudoku.sudoku.sudoku.model

import org.hibernate.validator.constraints.Range
import java.util.*

data class SudokuRequest(
        val seed: Long? = null,
        @Range(min = 18, max = 81) val showCount: Int = Random(seed ?: Random().nextLong()).nextInt(81 - 18) + 18
)
