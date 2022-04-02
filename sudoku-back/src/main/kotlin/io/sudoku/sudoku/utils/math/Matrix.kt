package io.sudoku.sudoku.utils.math

operator fun List<Int>.times(other: List<Int>): List<Int> {
    assert(this.size == 9)
    assert(this.size == other.size)

    return Array(9) { it }.let {
        it[0] = this[0] * other[0] + this[1] * other[3] + this[2] * other[6]
        it[1] = this[0] * other[1] + this[1] * other[4] + this[2] * other[7]
        it[2] = this[0] * other[2] + this[1] * other[5] + this[2] * other[8]

        it[3] = this[3] * other[0] + this[4] * other[3] + this[5] * other[6]
        it[4] = this[3] * other[1] + this[4] * other[4] + this[5] * other[7]
        it[5] = this[3] * other[2] + this[4] * other[5] + this[5] * other[8]

        it[6] = this[6] * other[0] + this[7] * other[3] + this[8] * other[6]
        it[7] = this[6] * other[1] + this[7] * other[4] + this[8] * other[7]
        it[8] = this[6] * other[2] + this[7] * other[5] + this[8] * other[8]

        it.toList()
    }
}