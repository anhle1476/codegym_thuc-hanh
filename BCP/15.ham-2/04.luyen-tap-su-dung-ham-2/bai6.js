const isPositiveInteger = (num) => num >= 0 && num % 1 === 0;

// true
console.log(isPositiveInteger(234));
console.log(isPositiveInteger(0));
// false
console.log(isPositiveInteger(234.324));
console.log(isPositiveInteger(-234));
console.log(isPositiveInteger(-234.23));
