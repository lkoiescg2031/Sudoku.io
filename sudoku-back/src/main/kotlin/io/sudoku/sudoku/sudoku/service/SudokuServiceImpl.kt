package io.sudoku.sudoku.sudoku.service

import io.sudoku.sudoku.math.times
import io.sudoku.sudoku.sudoku.model.Sudoku
import io.sudoku.sudoku.sudoku.model.SudokuRequest
import org.springframework.stereotype.Service
import java.util.*

@Service
class SudokuServiceImpl : SudokuService {

    override fun getRandomMap(sudokuRequest: SudokuRequest): Sudoku {
        val s0 = sudokuRequest.seed?.let {
            getLine(it)
        } ?: getLine()

        val map = getMap(s0)
        val ret = filterMap(map, sudokuRequest.showCount)

        return Sudoku(ret)
    }

    private fun getLine(): List<Int> = (1..9).toList().shuffled()

    private fun getLine(seed: Long): List<Int> = (1..9).toList().shuffled(Random(seed))

    private fun getMap(s0: List<Int>): List<List<Int>> {

        val x1 = listOf(0, 0, 1, 1, 0, 0, 0, 1, 0)
        val x2 = listOf(0, 1, 0, 0, 0, 1, 1, 0, 0)

        val s1 = x2 * s0
        val s2 = x1 * s0
        val s3 = s0 * x1
        val s4 = x2 * s0 * x1
        val s5 = x1 * s0 * x1
        val s6 = s0 * x2
        val s7 = x2 * s0 * x2
        val s8 = x1 * s0 * x2

        return listOf(s0, s1, s2, s3, s4, s5, s6, s7, s8)
    }

    private fun filterMap(map: List<List<Int>>, showCount: Int): List<List<Int>> {
        var random = Random()

        var cnt = 0
        var ret = Array(9) { Array(9) { 0 } }

        while (true) {
            var i = random.nextInt(8) + 1
            var j = random.nextInt(8) + 1

            if (ret[i][j] == 0 && random.nextBoolean()) {
                ret[i][j] = map[i][j]
                cnt++
                if (cnt >= showCount) {
                    return ret.map { it.toList() }.toList()
                }
            }
        }
    }
}