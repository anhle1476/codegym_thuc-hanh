import Renderer from "./Renderer.js";
import Street from "./object/Street.js";
import Car from "./object/Car.js";
import Start from "./object/Start.js";
import Coin from "./object/Coin.js";
import Trunk from "./object/Trunk.js";

import { loadImage } from "./loader.js";
import { loadSprite } from "./setup/sprite/spriteLoader.js";

const canvas = document.getElementById("canvas");

canvas.width = 646;
canvas.height = 898;

const ctx = canvas.getContext("2d");

const renderer = new Renderer();

loadImage("./img/sprite.png").then((image) => {
  const spriteSheet = loadSprite(image);

  const street = new Street();
  const car = new Car();
  const start = new Start();
  const coin = new Coin();
  const trunk = new Trunk();

  spriteSheet.draw(ctx, street);
  spriteSheet.draw(ctx, start);
  spriteSheet.draw(ctx, car);
  spriteSheet.draw(ctx, coin);
  spriteSheet.draw(ctx, trunk);
});
