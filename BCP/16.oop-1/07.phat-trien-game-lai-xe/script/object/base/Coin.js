import Object from "./Object.js";

export default class Coin extends Object {
  constructor(x, y) {
    super("coin", x, y, 48, 48);
  }
}
