export default class Object {
  constructor(name, x, y, width, height) {
    this.name = name;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  increaseY(amount) {
    this.y += amount;
  }
}
