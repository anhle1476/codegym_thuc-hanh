import Keyboard from "./Keyboard.js";

export function setupKeyboard(car, speed) {
  const keyboard = new Keyboard();

  const increaseSpeed = () => {
    console.log(speed);
    speed.increaseSpeed();
    console.log(speed);
  };

  keyboard.addKey(37, () => {
    console.log(car.x);
    car.moveLeft(3);
  });
  keyboard.addKey(39, () => {
    console.log(car.x);
    car.moveRight(7);
  });
  keyboard.addKey(17, () => increaseSpeed());
  keyboard.addKey(38, () => increaseSpeed());

  window.addEventListener("keydown", keyboard.keyboardHandler);
}
