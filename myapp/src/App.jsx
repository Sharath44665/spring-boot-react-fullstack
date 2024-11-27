import { useState } from 'react'
// import reactLogo from './assets/react.svg'
// import viteLogo from '/vite.svg'
import './App.css'

function App() {
  return(
  <>
  <h1>Counters updated seperately</h1>
  
  <MyBtn/>
  <MyBtn/>

  </>
 );
}

function MyBtn(){
  const [count, setCount] = useState(0);
  function handleClick(){
    setCount(count +1)
  }
  return (<button onClick={handleClick}>Clicked {count} times</button>);
}


export default App
