 /* eslint-disable */ 
import React from 'react'
import classnames from 'classnames/bind';

import useCurser from '../../hook/useCurser';
import useCell from '../../hook/useCell';

import style from './index.module.scss'

const cx = classnames.bind(style);
 
const Cell = ({x, y}) => {
  const { num, isFixed, updateNumBoard } = useCell(x,y);
  const { curX, curY, updateCurser } = useCurser();
  const selectCurser = () => {
    updateCurser(x,y);
    // 추가본
    updateNumBoard(x,y);
  }

  return (
    <div className={cx('cell',{ 
      isFixed,
      isZero : num === 0, 
      isSelected : x === curX && y === curY 
    })}
      onClick={selectCurser}
    >{num || num != 0}</div>
  )
}

export default Cell;