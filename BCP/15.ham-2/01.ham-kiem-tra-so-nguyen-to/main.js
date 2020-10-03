// Sieve of Eratosthenes algorithm approach
const primeListing = (toNum) => {
  const numbers = [];
  for (let i = 2; i <= toNum; i++) {
    numbers[i] = true;
  }

  const limit = Math.sqrt(toNum);
  for (let i = 2; i <= limit; i++) {
    if (numbers[i]) {
      for (let j = i * i; j <= toNum; j += i) {
        if (numbers[j]) numbers[j] = false;
      }
    }
  }

  const result = [];
  numbers.forEach((val, i) => {
    if (val === true) result.push(i);
  });

  return result;
};

console.log(primeListing(1000));
