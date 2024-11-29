const today = new Date();

const person = {
  name: 'Gregorio Y. Zara',
  theme: {
    backgroundColor: 'black',
    color: 'pink'
  }
};

function formatDate(myDate){
  return new Intl.DateTimeFormat(
    'en-IN',
    {weekday:"long"}
  ).format(myDate)
}

export default function ToDoList(){
  return (
  <>
    <h1>To do list for {formatDate(today)} </h1> 
    <div style={person.theme}>
      <h2>{person.name}</h2>
      <img
        className="avatar"
        src="https://i.imgur.com/7vQD0fPs.jpg"
        alt="Gregorio Y. Zara"
      />

      <ul>
        <li>Improve the videophone</li>
        <li>Prepare aeronautics lectures</li>
        <li>Work on the alcohol-fuelled engine</li>
      </ul>
    </div>
  </>
);


}

// import Gallery  from "./Gallery";
// import { Profile } from "./Profile";

// export default function App(){
//   return (
//     <>
//     <Profile />
//     <Gallery />
//     </>
//   );
// }