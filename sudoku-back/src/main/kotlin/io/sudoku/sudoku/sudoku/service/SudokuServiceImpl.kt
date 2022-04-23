package io.sudoku.sudoku.sudoku.service

import io.sudoku.sudoku.board.model.Board
import io.sudoku.sudoku.board.service.BoardService
import io.sudoku.sudoku.sudoku.mapper.SudokuMapper
import io.sudoku.sudoku.sudoku.model.Sudoku
import io.sudoku.sudoku.sudoku.model.SudokuRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class SudokuServiceImpl : SudokuService {

    @Autowired
    private lateinit var boardService: BoardService

    @Autowired
    private lateinit var sudokuMapper: SudokuMapper

    override fun createRandomSudoku(sudokuRequest: SudokuRequest): Sudoku {
        val board = boardService.createRandomBoard(sudokuRequest.seed, sudokuRequest.showCount)
        val sudoku = Sudoku.createNewGame(board)
        sudokuMapper.insertSudoku(sudoku)
        return sudoku
    }

    override fun updateCorrectSudoku(gameId: String, answer: Board): Sudoku {
        val origin = sudokuMapper.selectSudoku(gameId)

        if (!boardService.isOriginBoard(answer, origin.map!!)) {
            throw IllegalArgumentException("조작된 유저의 정답")
        }

        origin.correct = boardService.isCorrectBoard(answer)
        origin.correctDate = LocalDateTime.now()

        sudokuMapper.updateSudoku(origin)
        return origin
    }

}