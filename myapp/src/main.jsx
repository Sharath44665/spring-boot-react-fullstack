import React from 'react';
import ReactDOM from 'react-dom/client';
// import App from './App'

class MyApp extends React.Component{
    onInputChange(event){
        console.log(event.target.value);
    }

    render() {
        return (
            <div>
                <form>
                    <label htmlFor="">Enter Text</label>
                    <input type='text' onChange={this.onInputChange}/>
                </form>
            </div>
        );
    }
}


// ReactDOM.render(<MyApp/>, document.querySelector('#root')); // depricated
const container = document.getElementById('root');

const root = ReactDOM.createRoot(container);

root.render(<MyApp/>)