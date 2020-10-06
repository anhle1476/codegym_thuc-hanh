import RacingStreet from "./object/RacingStreet.js";
import Car from "./object/base/Car.js";
// import Start from "./object/base/Start.js";
import MovingLayer from "./setup/layer/MovingLayer.js";
import Compositor from "./Compositor.js";

import { loadImage } from "./loader.js";
import { loadSprite } from "./setup/sprite/spriteLoader.js";
import Obstacles from "./object/Obstacles.js";
import Speed from "./setup/speed/Speed.js";
import { setupKeyboard } from "./keyboard/setupKeyboard.js";

const ctx = document.getElementById("canvas").getContext("2d");

let isPause = false;
document
  .getElementById("pause")
  .addEventListener("click", () => (isPause = true));

loadImage("./img/sprite.png").then((image) => {
  const spriteSheet = loadSprite(image);

  // object draw
  // draw(ctx, spriteSheet) => spriteSheet.draw(ctx, obj);
  // layer draw
  // drawObjects(ctx) => obj.draw(ctx, this.spriteSheet)
  // compositor draw
  // drawLayers() => layer.drawObj(this.ctx)

  const gameSpeed = new Speed();
  const compositor = new Compositor(ctx);

  const car = new Car(248, 650);
  const racingStreet = new RacingStreet();
  const obstacles = new Obstacles();

  const movingLayer = new MovingLayer(spriteSheet, gameSpeed);

  movingLayer.addObject(racingStreet);
  movingLayer.addObject(obstacles);

  compositor.addLayer(movingLayer);

  setupKeyboard(car, gameSpeed);

  function gameLoop() {
    if (isPause) return;

    compositor.run();

    spriteSheet.draw(ctx, car);

    requestAnimationFrame(gameLoop);
  }

  gameLoop();
});
