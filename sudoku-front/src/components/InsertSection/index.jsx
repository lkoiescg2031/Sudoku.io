/* eslint-disable */ 
import React from 'react'
import classnames from 'classnames/bind';

import style from './index.module.scss'

import InsertPanel from '../InsertPanel';
import ResetPanel from '../ResetPanel';

const cx = classnames.bind(style);

const InsertSection = () => {
    return (
        <div className={cx('ins_wrap')}>
            <InsertPanel />
            <ResetPanel />
        </div>
    )
}

export default InsertSection;
 