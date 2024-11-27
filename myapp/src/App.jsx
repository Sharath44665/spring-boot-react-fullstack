import { useState } from "react";


function Square({value, onSquareClick}){
  return <button className="square" onClick={onSquareClick} >{value}</button>
}

// main fn
export default function Board() {
  const [xisNext, setXIsNext] = useState(true);
  const [squares, setSquares] = useState(Array(9).fill(null)); //Array(9).fill(null) creates an array with nine elements and sets each of them to null

  function handleClick(i){
    if (squares[i] || calculateWinner(squares)){
      return
    }
    const nextSquares = squares.slice();
    if (xisNext){
      nextSquares[i] = "X"
    }
    else{
      nextSquares[i] ="O"
    }

    setSquares(nextSquares)
    setXIsNext(!xisNext)
    // console.log(squares) // [null 9 times]
    // const nextSquares = squares.slice(); //slice: Returns a copy of a section of an array, here nothing mentioned like start or end, so returns the latest updated array.
    // nextSquares[i] = "X"
    // console.log(nextSquares) // [X for clicked ones ]
    // setSquares(nextSquares)
  }

  const winner = calculateWinner(squares);
  let status;
  if (winner) {
    status =`winner: ${winner}`
  }
  else{
    status = `Next player : ${xisNext? 'X': 'O'}`
  }
  return (
    <>
    <div className="status">{status}</div>
    <div className="board-row">
      <Square value={squares[0]} onSquareClick={() => handleClick(0)} />
      <Square value={squares[1]} onSquareClick={() => handleClick(1)} />
      <Square value={squares[2]} onSquareClick={() => handleClick(2)}/>
    </div>
    <div className="board-row">
      <Square value={squares[3]} onSquareClick={() => handleClick(3)}/>
      <Square value={squares[4]} onSquareClick={() => handleClick(4)}/>
      <Square value={squares[5]} onSquareClick={() => handleClick(5)}/>
    </div>
    <div className="board-row">
      <Square value={squares[6]} onSquareClick={() => handleClick(6)}/>
      <Square value={squares[7]} onSquareClick={() => handleClick(7)}/>
      <Square value={squares[8]} onSquareClick={() => handleClick(8)}/>
    </div>
    
    </>
  
);
}

function calculateWinner(squares){
  const lines = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6]
  ];

  for(let idx =0; idx < lines.length; idx += 1){
    const [a, b, c] = lines[idx];
    
    // Check that the row or column or diagonal is equal or not.
    // example we got [3, 4, 5]
    // now we check square[3] === square[4] or square[3] === square[5]
    // then return square[3]
    if (squares[a] === squares[b] && squares[a] === squares[c]){
      return squares[a];
    }
  }
  return null;
}



