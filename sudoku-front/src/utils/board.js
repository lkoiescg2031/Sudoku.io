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

// 추가본 - numberBoard
export const createNumBoard = (value) => {
  const board = [];

  for(let i = 0 ; i < 9; i++) {
    board.push(value);
  }

  return board;
}

// 추가본
export const checkBoard = (numBoard, board, curX, curY) => {
  // 해당셀의 위치 확인, x는 보드 넘버
  // 보드 내 확인
  numBoard = checkCurrentBoard(numBoard, board[curX]);
  // x축 확인
  numBoard = checkXAxisBoard(numBoard, board, curX, curY);
  // y축 확인
  numBoard = checkYAxisBoard(numBoard, board, curX, curY);
  return numBoard;
}

const checkCurrentBoard = (numBoard, curBoard) => {

  for(let i = 0 ; i < 9; i++) {
    let num = curBoard[i] - 1;
    if(num == -1) continue;
    numBoard[num] = false;
  }
  return numBoard;
}

const checkXAxisBoard = (numBoard, board, curX, curY) => {
  for(let i = 0; i < 3; i++) {
    for(let j = 0; j < 3; j++) {
      let tmpX = Math.floor(curX / 3);
      let tmpY = Math.floor(curY / 3);
      let tmp = board[tmpX * 3 + i][tmpY * 3 + j] - 1;
      if(tmp == -1) continue;
      numBoard[tmp] = false;
    }
  }

  return numBoard;
}

const checkYAxisBoard = (numBoard, board, curX, curY) => {
  for(let i = 0; i < 3; i++) {
    for(let j = 0; j < 3; j++) {
      let tmp = board[(curX + (3 * i))%9][(curY + (3 * j))%9] - 1;
      if(tmp == -1) continue;
      numBoard[tmp] = false;
    }
  }

  return numBoard;
}


const Module = {
  createBoard,
  createNumBoard,
  checkBoard,
}

export default Module;