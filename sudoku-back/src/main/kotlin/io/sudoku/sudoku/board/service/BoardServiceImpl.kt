package io.sudoku.sudoku.board.service

import io.sudoku.sudoku.board.model.Board
import io.sudoku.sudoku.board.model.Board.Companion.createBoardByCell
import io.sudoku.sudoku.board.model.Board.Companion.toBoard
import io.sudoku.sudoku.board.model.Cell.Companion.createRandomCell
import io.sudoku.sudoku.utils.groupByIndexed
import org.springframework.stereotype.Service

@Service
class BoardServiceImpl : BoardService {

    override fun isOriginBoard(target: Board, board: Board): Boolean {
        board.forEachIndexed { i, cell ->
            cell.forEachIndexed { j, sourceValue ->
                if (sourceValue == 0) {
                    return@forEachIndexed
                }

                val targetValue = target[i][j]
                if (targetValue != sourceValue) {
                    return false
                }
            }
        }

        return true
    }

    // FIXME 합 검사 말고 1 - 9 까지 모두 있는지 확인 해야함
    override fun isCorrectBoard(answer: Board): Boolean {

        if (answer.any { it.sum() != SUM }) {
            return false
        }

        if (answer.flatten().groupByIndexed { index, _ -> index / 9 % 3 to index % 3 }.values.any { it.sum() != SUM }) {
            return false
        }

        if (answer.flatten().groupByIndexed { index, _ -> index / 27 to index % 9 / 3 }.values.any { it.sum() != SUM }) {
            return false
        }

        return true
    }

    override fun createRandomBoard(seed: Long?, showCount: Int): Board {
        val randomCell = createRandomCell(seed)
        val randomBoard = createBoardByCell(randomCell)
        return Array(81) { 0 }.apply {
            randomBoard.flatten().withIndex().shuffled().take(showCount).forEach { (index, value) ->
                this[index] = value
            }
        }.toList().chunked(9).toBoard()
    }

    companion object {
        private val SUM = (1..9).sum()
    }
}