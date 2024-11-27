import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  // const [count, setCount] = useState(0)
 
  const myArr = ['apple', 'banana', 'orange']
  const myList = myArr.map((item) => <p>{item}</p>);
  
  return (
    <>

    
    {myList}

    
    </>
  );
}

export default App
