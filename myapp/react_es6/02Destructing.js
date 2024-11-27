const vehicleOne = {brand: 'Ford',
    model: 'Mustang',
    type: 'car',
    year: 2021, 
    color: 'red'
}

function myVehicle({type, color, brand, model})  {
    return `my ${type} is a ${color} ${brand} ${model}`;
}

console.log(myVehicle(vehicleOne)); // my car is a red Ford Mustang

const vehicleTwo = {
    brand: 'Ford',
    model: 'Mustang',
    type: 'car',
    year: 2021, 
    color: 'red',
    registration: {
      city: 'Houston',
      state: 'Texas',
      country: 'USA'
    }
  }

function getInfo({model, registration: {state}}){
    return `my ${model} is registrated in ${state}`
}

console.log(getInfo(vehicleTwo)) // my Mustang is registrated in Texas
