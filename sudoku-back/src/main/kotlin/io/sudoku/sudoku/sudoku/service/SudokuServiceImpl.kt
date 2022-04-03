package io.sudoku.sudoku.sudoku.service

import io.sudoku.sudoku.board.service.BoardService
import io.sudoku.sudoku.sudoku.mapper.SudokuMapper
import io.sudoku.sudoku.sudoku.model.Sudoku
import io.sudoku.sudoku.sudoku.model.SudokuRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SudokuServiceImpl : SudokuService {

    @Autowired
    private lateinit var boardService: BoardService

    @Autowired
    private lateinit var sudokuMapper: SudokuMapper

    override fun createRandomSudoku(sudokuRequest: SudokuRequest): Sudoku {
        val board = boardService.createRandomBoard(sudokuRequest.seed, sudokuRequest.showCount)
        val sudoku = Sudoku.createRandomSudou(board)
        sudokuMapper.insertSudoku(sudoku)
        return sudoku
    }

}