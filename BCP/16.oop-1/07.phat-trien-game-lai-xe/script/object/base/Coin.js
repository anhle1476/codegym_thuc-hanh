import Object from "./Object.js";

export default class Coin extends Object {
  constructor(x, y) {
    super("coin", x, y, 48, 48);
    this.isShow = true;
  }

  hit(game) {
    if (this.isShow) {
      game.increaseScore();
      this.isShow = false;
    }
  }
}
