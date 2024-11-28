// import React from 'react';
import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';

import App from './App'
import './App.css'

const root = createRoot(document.getElementById("root"));
root.render(
  <StrictMode>
    <App />
  </StrictMode>
);


// // ReactDOM.render(<MyApp/>, document.querySelector('#root')); // depricated
// const container = document.getElementById('root');

// const root = ReactDOM.createRoot(container);

// root.render(<App/>)