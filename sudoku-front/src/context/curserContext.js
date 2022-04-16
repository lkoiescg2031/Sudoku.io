/* eslint-disable */
import React, { useState } from 'react'

const INIT_CONTEXT = {
  curX: null,
  curY: null,
  updateCurser: (x,y) => {}
}

const CurserContext = React.createContext(INIT_CONTEXT);

export const CurserProvider = ({ children }) => {

  const [curX, setCurX] = useState(null);
  const [curY, setCurY] = useState(null);

  const updateCurser = (x,y) => {
    setCurX(x);
    setCurY(y);
  }

  const value = {
    curX,
    curY,
    updateCurser
  };

  return <CurserContext.Provider value={value}>
    {children}
  </CurserContext.Provider>
}

export default CurserContext;