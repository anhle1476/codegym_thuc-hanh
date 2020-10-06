export default class Keyboard {
  constructor() {
    this.keysMap = new Map();
    this.currentKey = new Map();

    this.keyDownHandler = this.keyDownHandler.bind(this);
    this.keyUpHandler = this.keyUpHandler.bind(this);
  }

  addKey(keyType, keyCode, keyDown, keyUp) {
    this.keysMap.set(keyCode, {
      type: keyType,
      changeState: keyDown,
      restoreState: keyUp,
    });
  }

  keyDownHandler(e) {
    if (e.repeat) return;
    const currentSet = this.keysMap.get(e.keyCode);

    if (currentSet) {
      // newer key of the same type overwrite the older ones
      this.currentKey.set(currentSet.type, e.keyCode);

      currentSet.changeState();
    }
  }

  keyUpHandler({ keyCode }) {
    const currentSet = this.keysMap.get(keyCode);

    if (currentSet && this.currentKey.get(currentSet.type) === keyCode) {
      currentSet.restoreState();

      this.currentKey.delete(currentSet.type);
    }
  }
}
