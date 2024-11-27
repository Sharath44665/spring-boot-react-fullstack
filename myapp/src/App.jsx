import { useState } from 'react'
// import reactLogo from './assets/react.svg'
// import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [count, setCount] = useState(0);

  function handleClick() {
    setCount(count + 1);
  }
  return(
  <>
  <h1>Counters updated together</h1>
  
  <MyBtn myCounter={count} demoEvent={handleClick} />
  <MyBtn myCounter={count} demoEvent={handleClick} />

  </>
 );
}

function MyBtn({ myCounter, demoEvent }) {
  return (
    <button onClick={demoEvent}>
      Clicked {myCounter} times
    </button>
  );
}


export default App
