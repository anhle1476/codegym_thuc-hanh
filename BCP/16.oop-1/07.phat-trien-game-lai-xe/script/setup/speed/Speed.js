export default class Speed {
  constructor() {
    this.speed = 3;
    this.max = 10;
    this.min = 3;
  }

  increaseSpeed() {
    if (this.speed < this.max) {
      this.speed += 0.25;
    }
  }

  update() {
    if (this.speed > this.max) {
      this.speed -= 0.5;
    } else {
      this.speed = 3;
    }
  }
}
