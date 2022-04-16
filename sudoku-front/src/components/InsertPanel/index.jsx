/* eslint-disable */ 
import React from 'react'
import classnames from 'classnames/bind';

import usePanel from '../../hook/usePanel';
import InsertBtn from '../InsertBtn/index';

import style from './index.module.scss';

const cx = classnames.bind(style);

const INSERT_CHECK_BOARD = [1,2,3,4,5,6,7,8,9];

const InsertPanel = () => {
    const { numBoard } = usePanel();

    return (
        <div className={cx('ins_panel')}>
            {INSERT_CHECK_BOARD.map((num, idx) =>
                <InsertBtn num={num} key={idx} isChecked={!numBoard[num-1]} />
            )}
        </div>
    )
}

export default InsertPanel;
 