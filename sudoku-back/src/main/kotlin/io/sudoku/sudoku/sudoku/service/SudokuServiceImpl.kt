package io.sudoku.sudoku.sudoku.service

import io.sudoku.sudoku.board.service.BoardService
import io.sudoku.sudoku.sudoku.model.Sudoku
import io.sudoku.sudoku.sudoku.model.SudokuRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class SudokuServiceImpl : SudokuService {
    @Autowired
    private lateinit var boardService: BoardService

    override fun createRandomSudoku(sudokuRequest: SudokuRequest): Sudoku {
        val board = boardService.createRandomMap(sudokuRequest.seed, sudokuRequest.showCount)
        val uuid = UUID.randomUUID().toString()

        return Sudoku(uuid, board);
    }

}