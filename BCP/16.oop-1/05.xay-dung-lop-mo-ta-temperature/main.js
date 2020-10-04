class Temperature {
  constructor(degInC) {
    this.degInC = degInC;
  }

  toF() {
    return this.degInC * 1.8 + 32;
  }

  toK() {
    return this.degInC + 273.15;
  }
}

const myTemp = new Temperature(25);

console.log("F: " + myTemp.toF());
console.log("K: " + myTemp.toK());
