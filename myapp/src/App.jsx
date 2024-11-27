import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function MyButton() {
  return (
    <button>
      I'm a button
    </button>
  );
}


function App() {
  // const [count, setCount] = useState(0)
  const user = {
    name: 'Hedy Lamarr',
    imageUrl: 'https://i.imgur.com/yXOvdOSs.jpg',
    imageSize: 90,
  };
  
  
  return (
    <>
    <h1>{user.name}</h1>
    <img className='avatar' src={user.imageUrl} 
      style={{width:user.imageSize, height: user.imageSize}}/>

    </>
  );
}

export default App
