const today = new Date();

function formatDate(myDate){
  return new Intl.DateTimeFormat(
    'en-IN',
    {weekday:"long"}
  ).format(myDate)
}

export default function ToDoList(){
  return (<h1>To do list for {formatDate(today)} </h1> );
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