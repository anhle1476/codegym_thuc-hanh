import Object from "./Object.js";

export default class Car extends Object {
  constructor(x, y) {
    super("car", x, y, 78, 185);
  }

  moveRight(amount) {
    this.x += amount;
  }

  moveLeft(amount) {
    this.x -= amount;
  }
}
