package io.sudoku.sudoku.board.model

import java.util.*

class Cell(private val cell: List<Int>) : List<Int> by cell {

    init {
        if (this.size != 9) {
            throw IllegalStateException("cell 은 반드시 9개의 숫자를 가져야 합니다.")
        }
    }

    operator fun times(other: Cell): Cell = Array(9) { it }.let {
        it[0] = this[0] * other[0] + this[1] * other[3] + this[2] * other[6]
        it[1] = this[0] * other[1] + this[1] * other[4] + this[2] * other[7]
        it[2] = this[0] * other[2] + this[1] * other[5] + this[2] * other[8]

        it[3] = this[3] * other[0] + this[4] * other[3] + this[5] * other[6]
        it[4] = this[3] * other[1] + this[4] * other[4] + this[5] * other[7]
        it[5] = this[3] * other[2] + this[4] * other[5] + this[5] * other[8]

        it[6] = this[6] * other[0] + this[7] * other[3] + this[8] * other[6]
        it[7] = this[6] * other[1] + this[7] * other[4] + this[8] * other[7]
        it[8] = this[6] * other[2] + this[7] * other[5] + this[8] * other[8]

        Cell(it.toList())
    }

    companion object {
        inline fun createRandomCell(seed: Long?): Cell = seed?.let {
            (1..9).toList().shuffled(Random(it)).toCell()
        } ?: (1..9).toList().shuffled().toCell()

        inline fun List<Int>.toCell() = Cell(this)
        inline fun cellOf(vararg elements: Int): Cell = Cell(elements.toList())
    }
}