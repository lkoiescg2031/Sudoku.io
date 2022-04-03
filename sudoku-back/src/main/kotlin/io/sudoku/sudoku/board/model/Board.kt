package io.sudoku.sudoku.board.model


import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.node.ArrayNode
import io.sudoku.sudoku.board.model.Cell.Companion.toCell
import io.sudoku.sudoku.common.config.typehandler.JsonTypeHandler
import io.sudoku.sudoku.utils.LoggerDelegate
import org.apache.ibatis.type.MappedTypes

@JsonDeserialize(using = Board.Companion.DeserializeBoard::class)
class Board(private val map: List<Cell>) : List<Cell> by map {

    init {
        if (this.size != 9) {
            throw IllegalStateException("board 는 반드시 9개의 cell 을 가져야 합니다.")
        }
    }


    companion object {
        private val log by LoggerDelegate()

        inline fun createBoardByCell(s0: Cell): Board {

            val x1 = Cell.cellOf(0, 0, 1, 1, 0, 0, 0, 1, 0)
            val x2 = Cell.cellOf(0, 1, 0, 0, 0, 1, 1, 0, 0)

            val s1 = x2 * s0
            val s2 = x1 * s0
            val s3 = s0 * x1
            val s4 = x2 * s0 * x1
            val s5 = x1 * s0 * x1
            val s6 = s0 * x2
            val s7 = x2 * s0 * x2
            val s8 = x1 * s0 * x2

            return boardOf(s0, s1, s2, s3, s4, s5, s6, s7, s8)
        }

        inline fun boardOf(vararg cells: Cell) = Board(cells.toList())

        inline fun List<List<Int>>.toBoard() = Board(map { it.toCell() })

        @MappedTypes(Board::class)
        class BoardTypeHandler : JsonTypeHandler<Board>(Board::class.java)

        class DeserializeBoard : JsonDeserializer<Board>() {
            override fun deserialize(parser: JsonParser?, ctxt: DeserializationContext?): Board {
                val arrayNode = parser?.codec?.readTree<ArrayNode>(parser)
                return arrayNode?.map { cell ->
                    cell?.map {
                        it.intValue()
                    }!!
                }!!.toBoard()
            }
        }
    }
}