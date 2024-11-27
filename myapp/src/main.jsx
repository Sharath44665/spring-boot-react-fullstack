// import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App'



// ReactDOM.render(<MyApp/>, document.querySelector('#root')); // depricated
const container = document.getElementById('root');

const root = ReactDOM.createRoot(container);

root.render(<App/>)