import { SPEED_STATE } from "../../controller/gameConst/state.js";

export default class Speed {
  constructor() {
    this.speed = 3;
    this.max = 8;
    this.min = 5;
    this.setState(SPEED_STATE.NORMAL);
  }

  setState(state) {
    this.state = state;
  }

  increaseSpeed() {
    if (this.speed < this.max) {
      this.speed += 0.5;
    }
  }

  normalizeSpeed() {
    if (this.speed > this.min) {
      this.speed -= 0.5;
    }
  }

  update() {
    if (this.state === SPEED_STATE.NORMAL) {
      this.normalizeSpeed();
    } else {
      this.increaseSpeed();
    }
  }
}
