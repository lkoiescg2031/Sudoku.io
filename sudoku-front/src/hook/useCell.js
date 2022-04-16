import { useContext } from 'react';

import GameContext from '../context/gameContext';

export default function useCell(x, y) {
  const { board, isFixed, updateNumBoard } = useContext(GameContext)

  return {
    num : board[x][y],
    isFixed : isFixed[x][y],
    updateNumBoard
  };
}
