 /* eslint-disable */ 
 import React from 'react';
 import classnames from 'classnames/bind';
 
 import Cell from '../Cell';

 import style from './index.module.scss'
 
 const cx = classnames.bind(style);
 
 const BoardSection = ({ x }) => {
 
   return (
     <div className={cx('section')}>
       {new Array(9).fill(0).map((_, idx) => 
         <Cell key={idx} x={x} y={idx} />
       )}
     </div>
   )
 }
 
 export default BoardSection;
 