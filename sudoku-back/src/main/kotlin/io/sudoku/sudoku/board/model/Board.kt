package io.sudoku.sudoku.board.model

import io.sudoku.sudoku.common.config.typehandler.JsonTypeHandler
import org.apache.ibatis.type.MappedTypes

class Board(map: List<List<Int>>) : List<List<Int>> by map {
    companion object {
        @MappedTypes(Board::class)
        class BoardTypeHandler : JsonTypeHandler<Board>(Board::class.java)
    }
}