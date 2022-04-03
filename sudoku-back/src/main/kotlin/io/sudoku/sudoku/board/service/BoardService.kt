package io.sudoku.sudoku.board.service

import io.sudoku.sudoku.board.model.Board

interface BoardService {

    fun createRandomBoard(seed: Long?, showCount: Int): Board
    fun isCorrectBoard(answer: Board): Boolean
    fun isOriginBoard(target: Board, source: Board): Boolean
}