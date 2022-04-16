import { useContext } from 'react';

import GameContext from '../context/gameContext';

export default function usePanel() {
    const { numBoard } = useContext(GameContext);
  
    return {
      numBoard
    }
  }
  
