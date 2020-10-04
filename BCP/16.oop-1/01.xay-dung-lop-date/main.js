class MyDate {
  constructor(day, month, year) {
    this.setDate(day, month, year);
  }

  setDay(day) {
    this.day = day;
  }

  setMonth(month) {
    this.month = month;
  }

  setYear(year) {
    this.year = year;
  }

  setDate(day, month, year) {
    this.setDay(day);
    this.setMonth(month);
    this.setYear(year);
  }

  getDay() {
    return this.day;
  }
  getMonth() {
    return this.month;
  }
  getYear() {
    return this.year;
  }

  _fixLeadingZero(num) {
    return num < 10 ? "0" + num : num;
  }

  toString() {
    return `${this._fixLeadingZero(this.day)}/${this._fixLeadingZero(
      this.month
    )}/${this.year}`;
  }
}

let date = new MyDate(2, 2, 2007);

console.log(date.getDay());
console.log(date.getMonth());
console.log(date.getYear());

console.log(date.toString());

date.setDay(10);
date.setMonth(10);
date.setYear(2019);

console.log(date.toString());
