import RacingStreet from "./object/RacingStreet.js";
import Car from "./object/base/Car.js";
import Obstacles from "./object/Obstacles.js";

import CollisionDetector from "./controller/collision/CollisionDetector.js";
import Game from "./controller/game/Game.js";
import Speed from "./setup/speed/Speed.js";

import Compositor from "./Compositor.js";
import MovingLayer from "./setup/layer/MovingLayer.js";
import UpperLayer from "./setup/layer/UpperLayer.js";

import { loadSprite } from "./setup/sprite/spriteLoader.js";
import { setupKeyboard } from "./keyboard/setupKeyboard.js";

export function initialSetup(image, ctx) {
  const game = new Game();
  const spriteSheet = loadSprite(image);
  const compositor = new Compositor(ctx);
  const gameSpeed = new Speed();

  // objects
  const car = new Car(248, 650);
  const racingStreet = new RacingStreet();
  const obstacles = new Obstacles();

  // layer
  const movingLayer = new MovingLayer(spriteSheet, gameSpeed);
  const upperLayer = new UpperLayer(spriteSheet);

  movingLayer.addObject(racingStreet);
  movingLayer.addObject(obstacles);
  compositor.addLayer(movingLayer);

  upperLayer.addObject(car);
  compositor.addLayer(upperLayer);

  // keyboard
  setupKeyboard(car, gameSpeed);

  // collision
  const collisionDetector = new CollisionDetector(game, car, obstacles);

  return [game, compositor, collisionDetector];
}
