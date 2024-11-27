import { useState } from "react";


function Square(){
  const [value, SetValue] = useState(null);

  function handleClick(){
    SetValue('X');
  }
  return <button className="square" onClick={handleClick}>{value}</button>
}
export default function Board() {
  return (
    <>
    <div className="board-row">
      <Square />
      <Square />
      <Square />
    </div>
    <div className="board-row">
      <Square />
      <Square />
      <Square />
    </div>
    <div className="board-row">
      <Square />
      <Square />
      <Square />
    </div>
    
    </>
  
);
}
