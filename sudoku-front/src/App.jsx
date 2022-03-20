/* eslint-disable */
// outside module
import React, {useState, useEffect} from 'react';

// component
import {GameProvider} from './context/gameContext';
import {CurserProvider} from './context/curserContext';
import SudokuBoard from './components/SudokuBoard';

// container

// api

// utils
import {getRandomIntFromRange} from "./utils/math"

// css
import "./App.scss";


function App() {
    
    return (
        <GameProvider>
            <CurserProvider>
                <div className="sdk">
                    <SudokuBoard/>
                </div>
            </CurserProvider>
        </GameProvider>);
}

export default App;
