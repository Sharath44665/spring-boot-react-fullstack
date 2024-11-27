const numbers = [1, 2, 3, 4, 5, 6];

const [one, two, ...rest] = numbers;

console.log(one); // 1
console.log(two); // 2
console.log(rest); // [ 3, 4, 5, 6 ]