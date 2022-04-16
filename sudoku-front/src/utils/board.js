/* eslint-disable */
export const createBoard = (value) => {
  const board = [];

  for(let i = 0 ; i < 9 ; i++) {
    const arr = [];

    for(let j = 0; j < 9 ; j++) {
      arr.push(value);
    }

    board.push(arr);
  }

  return board;
}

const Module = {
  createBoard
}

export default Module;