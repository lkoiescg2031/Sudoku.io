package io.sudoku.sudoku.sudoku.controller

import io.sudoku.sudoku.board.model.Board
import io.sudoku.sudoku.sudoku.model.Sudoku
import io.sudoku.sudoku.sudoku.model.SudokuRequest
import io.sudoku.sudoku.sudoku.service.SudokuService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/games")
@CrossOrigin
class SudokuController {

    @Autowired
    private lateinit var sudokuService: SudokuService

    @PostMapping("/random")
    fun createRandomSudoku(@RequestBody @Validated sudokuRequest: SudokuRequest
    ): Sudoku = sudokuService.createRandomSudoku(sudokuRequest)

    @PutMapping("/{gameId}/correct")
    fun updateGameCorrect(@PathVariable gameId: String, @RequestBody answer: Board
    ): Sudoku = sudokuService.updateCorrectSudoku(gameId, answer)
}