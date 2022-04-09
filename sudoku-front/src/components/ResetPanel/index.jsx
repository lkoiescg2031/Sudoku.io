/* eslint-disable */ 
import React from 'react'
import classnames from 'classnames/bind';

import style from './index.module.scss'

const cx = classnames.bind(style);

const ResetPanel = () => {
    const delBoard = () => {
        // 숫자 0 으로
        // 
    }
    
    const resetBoard = () => {
        // 리셋 보드
    }

    return (
        <div className={cx('reset_wrap')}>
            <button type="button" className={cx('reset_btn')} onClick={delBoard()}>삭제</button>
            <button type="button" className={cx('reset_all')} onClick={resetBoard()}>전체리셋</button>
        </div>
    )
}

export default ResetPanel;
 