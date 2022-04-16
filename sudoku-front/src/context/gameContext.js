/* eslint-disable */
import React, { useState, useEffect } from 'react'

import {fetchSudoku} from "../api/sudoku";

import { createBoard, createNumBoard, checkBoard } from '../utils/board';
import {getRandomIntFromRange} from "../utils/math"

const FETCHED_BOARD = [
  [0,0,0, 0,0,0, 0,0,0],
  [0,1,8, 6,5,4, 0,0,3],
  [0,5,0, 7,2,0, 9,0,8],

  [0,3,7, 1,8,0, 5,4,6],
  [0,8,0, 5,4,6, 2,3,7],
  [0,0,6, 2,3,0, 1,0,9],

  [0,7,2, 0,0,0, 0,6,0],
  [0,0,1, 0,6,5, 3,7,0],
  [0,6,5, 3,7,0, 8,0,1],
];

const INIT_BOARD = createBoard(0);
const INIT_FIXED = createBoard(true);
// 추가본
const INIT_BOARD_ID = null;
const INIT_NUM_BOARD = createNumBoard(true);

const INIT_CONTEXT = {
  board: INIT_BOARD,
  isFixed: INIT_FIXED,
  updateValue: (x,y,num) => {}
}

const GameContext = React.createContext(INIT_CONTEXT);

function deepCopyObj(obj) {
  return JSON.parse(JSON.stringify(obj));
}

export const GameProvider = ({ children }) => {

  const [board, setBoard] = useState(INIT_BOARD);
  const [isFixed, setIsFixed] = useState(INIT_FIXED);

  const [isLoading, setLoading] = useState(false);
  //추가본
  const [numBoard, setNumBoard] = useState(INIT_NUM_BOARD);
  const [boardId, setBoardId] = useState(null);

  // 추가본
  const updateNumBoard = (x, y) => {
    let newBoard = createNumBoard(true);

    newBoard = checkBoard(newBoard, board, x, y);

    setNumBoard(newBoard);
  }

  const getNewBoard = () => {

  }

  // 추가본
  const resetBoard = () => {
    // 나중에 FETCHED_BOARD 변경
    setBoard(FETCHED_BOARD);
    setNumBoard(INIT_NUM_BOARD);
  }

  const updateValue = (x, y, num) => {
    const newBoard = deepCopyObj(board);
    newBoard[x][y] = num;
    setBoard(newBoard);
  }

  const value = {
    board,
    isFixed,
    numBoard,
    updateValue,
    updateNumBoard
  };

  useEffect(() => {
    const fetchArr = async () => {
        try {
            setBoard(INIT_BOARD);
            setLoading(true);

            let map = null;
            
            // TODO change spy code\
            if(process.env.NODE_ENV === 'development') {
              map = FETCHED_BOARD;
            } else {
              const rand = getRandomIntFromRange(18, 81);
              const { data } = await fetchSudoku({params: {showCount: rand}});

              map = data.map;

            }

            setBoard(map);
            
            const updatedIsFixed = map.map((arr) => arr.map((ele) => ele !== 0));
            setIsFixed(updatedIsFixed);
        } finally {
            setLoading(false);
        }
    };
    
    fetchArr();
}, []);

  return <GameContext.Provider value={value}>
    {isLoading && <div>로딩중...</div>}
    {isLoading || children}
  </GameContext.Provider>
}

export default GameContext;