import Keyboard from "./Keyboard.js";
import { KEY_TYPE } from "../controller/gameConst/keyType.js";
import { CAR_STATE, SPEED_STATE } from "../controller/gameConst/state.js";

export function setupKeyboard(car, speed) {
  const keyboard = new Keyboard();

  const increaseSpeed = () => {
    speed.setState(SPEED_STATE.BOOST);
  };

  const restoreSpeed = () => {
    speed.setState(SPEED_STATE.NORMAL);
  };

  const carMoveLeft = () => {
    car.setState(CAR_STATE.MOVE_LEFT);
  };

  const carMoveRight = () => {
    car.setState(CAR_STATE.MOVE_RIGHT);
  };

  const carRestoreState = () => {
    car.setState(CAR_STATE.NORMAL);
  };

  keyboard.addKey(KEY_TYPE.DIRECTION, 37, carMoveLeft, carRestoreState);
  keyboard.addKey(KEY_TYPE.DIRECTION, 39, carMoveRight, carRestoreState);
  keyboard.addKey(KEY_TYPE.SPEED, 17, increaseSpeed, restoreSpeed);
  keyboard.addKey(KEY_TYPE.SPEED, 38, increaseSpeed, restoreSpeed);

  window.addEventListener("keydown", keyboard.keyDownHandler);
  window.addEventListener("keyup", keyboard.keyUpHandler);
}
