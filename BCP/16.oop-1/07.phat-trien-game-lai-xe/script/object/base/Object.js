export default class Object {
  constructor(name, x, y, width, height) {
    this.setName(name);
    this.setPosition(x, y);
    this.setSize(width, height);
  }

  setName(name) {
    this.name = name;
  }

  setPosition(x, y) {
    this.x = x;
    this.y = y;
  }

  increaseY(amount) {
    this.y += amount;
  }

  setSize(width, height) {
    this.width = width;
    this.height = height;
  }
}
