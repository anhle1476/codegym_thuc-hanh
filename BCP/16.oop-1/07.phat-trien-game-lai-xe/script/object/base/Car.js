import Object from "./Object.js";
import { CAR_STATE } from "../../controller/gameConst/state.js";

export default class Car extends Object {
  constructor(x, y) {
    super("car", x, y, 78, 184);
    this.setState(CAR_STATE.NORMAL);
  }

  setState(state) {
    this.state = state;
  }

  moveRight(amount) {
    this.x += amount;
  }

  moveLeft(amount) {
    this.x -= amount;
  }

  update() {
    switch (this.state) {
      case CAR_STATE.NORMAL:
        return;
      case CAR_STATE.MOVE_LEFT:
        this.moveLeft(5);
        break;
      case CAR_STATE.MOVE_RIGHT:
        this.moveRight(5);
    }
  }
}
