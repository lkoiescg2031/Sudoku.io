package io.sudoku.sudoku.board.service

import io.sudoku.sudoku.board.model.Board

interface BoardService {

    fun createRandomMap(seed: Long?, showCount: Int):Board;
}