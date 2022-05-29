package io.sudoku.sudoku.sudoku.service

import com.nhaarman.mockitokotlin2.*
import io.sudoku.sudoku.board.model.Board
import io.sudoku.sudoku.board.model.Cell
import io.sudoku.sudoku.board.service.BoardService
import io.sudoku.sudoku.sudoku.mapper.SudokuMapper
import io.sudoku.sudoku.sudoku.model.Sudoku
import io.sudoku.sudoku.sudoku.model.SudokuRequest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class SudokuServiceImplTest {

    @InjectMocks
    private lateinit var sudokuServiceImpl: SudokuServiceImpl

    @Mock
    private lateinit var boardService: BoardService

    @Mock
    private lateinit var sudokuMapper: SudokuMapper

    @Nested
    inner class `createRandomSudokuTest` {

        @Test
        fun createRandomSudoku() {
            //given
            val sudokuRequest = SudokuRequest(18, 30283954L)
            val board = Board(
                listOf(
                    Cell(listOf(5, 3, 0, 6, 0, 0, 0, 9, 8)),
                    Cell(listOf(0, 7, 0, 1, 9, 5, 0, 0, 0)),
                    Cell(listOf(0, 0, 0, 0, 0, 0, 0, 6, 0)),

                    Cell(listOf(8, 0, 0, 4, 0, 0, 7, 0, 0)),
                    Cell(listOf(0, 6, 0, 8, 0, 3, 0, 2, 0)),
                    Cell(listOf(0, 0, 3, 0, 0, 1, 0, 0, 6)),

                    Cell(listOf(0, 6, 0, 0, 0, 0, 0, 0, 0)),
                    Cell(listOf(0, 0, 0, 4, 1, 9, 0, 8, 0)),
                    Cell(listOf(2, 8, 0, 0, 0, 5, 0, 7, 9)),
                )
            )

            //mock
            doReturn(board).`when`(boardService).createRandomBoard(sudokuRequest.seed, sudokuRequest.showCount)
            doNothing().`when`(sudokuMapper).insertSudoku(isA())

            //when
            val actualSudoku = sudokuServiceImpl.createRandomSudoku(sudokuRequest)

            // then
            actualSudoku.map.let {
                Assertions.assertNotNull(it)
                Assertions.assertArrayEquals(board.flatten().toIntArray(), it!!.flatten().toIntArray())
            }

            Assertions.assertNotNull(actualSudoku.gameId)
            Assertions.assertNull(actualSudoku.answer)
            Assertions.assertNull(actualSudoku.correct)
            Assertions.assertNull(actualSudoku.correctDate)

            val captor = argumentCaptor<Sudoku>()
            verify(sudokuMapper, times(1)).insertSudoku(captor.capture())
            captor.firstValue.let {
                Assertions.assertEquals(actualSudoku.map, it.map)
                Assertions.assertEquals(actualSudoku.gameId, it.gameId)
                Assertions.assertEquals(actualSudoku.answer, it.answer)
                Assertions.assertEquals(actualSudoku.correct, it.correct)
                Assertions.assertEquals(actualSudoku.correctDate, it.correctDate)
            }
        }
    }

//
//    @Test
//    fun updateCorrectSudoku() {
//    }
}