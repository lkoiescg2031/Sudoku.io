package io.sudoku.sudoku.sudoku.model

import com.fasterxml.jackson.annotation.JsonInclude
import io.sudoku.sudoku.board.model.Board
import java.time.LocalDateTime
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Sudoku(
        var gameId: String,
        var map: Board?,
        var answer: Board?,
        var correct: Boolean?,
        var correctDate: LocalDateTime?
) {
    companion object {
        fun createNewGame(map: Board) = Sudoku(
                gameId = UUID.randomUUID().toString(),
                map = map,
                answer = null,
                correct = null,
                correctDate = null
        )
    }
}