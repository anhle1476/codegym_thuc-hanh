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

  setSize(width, height) {
    this.width = width;
    this.height = height;
  }
}
