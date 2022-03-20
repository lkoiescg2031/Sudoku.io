 /* eslint-disable */ 
 import React from 'react';
 import classnames from 'classnames/bind';

 import BoardSection from "../BoardSection";
 
 import style from './index.module.scss'

 const cx = classnames.bind(style);

 const SECTION_SIZE_ROW = 3;
 const SECTION_SIZE_COL = 3;
 
 const SudokuBoard = () => {

   return <div className={cx('board')}>
      {new Array(9).fill(0).map((_, idx) => 
        <BoardSection key={idx} x={idx} />
      )}
     </div>
 }
 
 export default SudokuBoard;