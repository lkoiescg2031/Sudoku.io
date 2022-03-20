import React from 'react'

import CurserContext from '../context/curserContext'

export default function useCurser() {
  return React.useContext(CurserContext)
}

