import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'


function App() {
  // const [count, setCount] = useState(0)
  const products = [
    { title: 'Cabbage', isFruit: false, id: 1 },
    { title: 'Garlic', isFruit: false, id: 2 },
    { title: 'Apple', isFruit: true, id: 3 },
  ];
  
  const listItems = products.map((prod) => { return (
    <li
    key = {prod.id}
    style = {{color: prod.isFruit ? 'magenta' : 'darkgreen'}}
    >
      {prod.title}
    </li>
    );

  });
 
  
  return (
    <>
    <ul>
    {listItems}
    </ul>
    

    </>
  );
}

export default App
