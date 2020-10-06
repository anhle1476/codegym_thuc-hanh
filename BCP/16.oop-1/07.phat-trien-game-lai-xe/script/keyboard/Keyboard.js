export default class Keyboard {
  constructor() {
    this.keys = new Map();
    this.keyboardHandler = this.keyboardHandler.bind(this);
  }

  addKey(keyCode, callback) {
    this.keys.set(keyCode, callback);
  }

  keyboardHandler({ keyCode }) {
    if (this.keys.has(keyCode)) {
      this.keys.get(keyCode)();
    }
  }
}
