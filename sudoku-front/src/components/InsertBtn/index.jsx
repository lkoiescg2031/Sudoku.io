/* eslint-disable */ 
import React, { useContext } from 'react'
import classnames from 'classnames/bind';

import useCurser from '../../hook/useCurser';
import GameContext from '../../context/gameContext';

import style from './index.module.scss'

const cx = classnames.bind(style);

function useCellHandler() {
    return  useContext(GameContext)
}

const InsertBtn = ({num}) => {    
    // 커서를 사용
    const { curX, curY } = useCurser();
    
    const { board, updateValue } = useGameContext();

    const setBoardNum = () => {
        // 보드에 숫자 추가
        // 현재 커서가 가지고 있는 위치 사용
        // 커서가 가지고 있는 위치의 div에 숫자 추가
        updateValue(curX, curY, num);
    }

    return (
        <button type="button" className={cx('ins_btn')} onClick={setBoardNum}>
            {num}
        </button>
    )
}

export default InsertBtn;
 