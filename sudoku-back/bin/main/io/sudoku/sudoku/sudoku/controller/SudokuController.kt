package io.sudoku.sudoku.sudoku.controller

import io.sudoku.sudoku.sudoku.model.Sudoku
import io.sudoku.sudoku.sudoku.model.SudokuRequest
import io.sudoku.sudoku.sudoku.service.SudokuService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/sudoku")
@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
class SudokuController {

    @Autowired
    private lateinit var sudokuService: SudokuService;

    @GetMapping("/random")
    fun getRandomMap(sudokuRequest: SudokuRequest): Sudoku
        = sudokuService.getRandomMap(sudokuRequest)
}