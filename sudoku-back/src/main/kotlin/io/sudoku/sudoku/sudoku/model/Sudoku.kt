package io.sudoku.sudoku.sudoku.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import io.sudoku.sudoku.board.model.Board
import java.time.LocalDateTime
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Sudoku(
    val gameId: UUID,
    val map: Board,
    val correct: Boolean?,
    val correctDate: LocalDateTime?,
    @JsonIgnore val regDate: LocalDateTime,
    @JsonIgnore val modDate: LocalDateTime
) {
    companion object {
        fun createRandomSudou(map: Board) = Sudoku(
                gameId = UUID.randomUUID(),
                map = map,
                correct = null,
                correctDate = null,
                regDate = LocalDateTime.now(),
                modDate = LocalDateTime.now(),
        )
    }
}