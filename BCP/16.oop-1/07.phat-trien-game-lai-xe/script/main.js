import Renderer from "./Compositor.js";
import RacingStreet from "./object/RacingStreet.js";
import Car from "./object/base/Car.js";
import Start from "./object/base/Start.js";
import Coin from "./object/base/Coin.js";
import Trunk from "./object/base/Trunk.js";

import { loadImage } from "./loader.js";
import { loadSprite } from "./setup/sprite/spriteLoader.js";
import Speed from "./setup/speed/Speed.js";
import MovingLayer from "./setup/layer/MovingLayer.js";
import Compositor from "./Compositor.js";

const ctx = document.getElementById("canvas").getContext("2d");

let isPause = false;
document
  .getElementById("pause")
  .addEventListener("click", () => (isPause = true));

loadImage("./img/sprite.png").then((image) => {
  const spriteSheet = loadSprite(image);

  const car = new Car(248, 650);
  // const start = new Start();
  // const coin = new Coin(50, 400);
  // const trunk = new Trunk(50, 200);

  const racingStreet = new RacingStreet(spriteSheet);

  // object draw
  // draw(ctx, spriteSheet) => spriteSheet.draw(ctx, obj);
  // layer draw
  // drawObjects(ctx) => obj.draw(ctx, this.spriteSheet)
  // compositor draw
  // drawLayers() => layer.drawObj(this.ctx)

  const compositor = new Compositor(ctx);

  const movingLayer = new MovingLayer(spriteSheet);

  compositor.addLayer(movingLayer);

  movingLayer.addObject(racingStreet);

  function gameLoop() {
    if (isPause) return;

    // racingStreet.update(3);
    // racingStreet.draw(ctx, spriteSheet);

    compositor.run();

    spriteSheet.draw(ctx, car);

    requestAnimationFrame(gameLoop);
  }

  gameLoop();
});
