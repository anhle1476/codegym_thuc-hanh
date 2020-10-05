import Renderer from "./Renderer.js";
import Street from "./object/Street.js";

import { loadImage } from "./loader.js";
import { loadSprite } from "./setup/sprite/spriteLoader.js";

const canvas = document.getElementById("canvas");

canvas.width = 646;
canvas.height = window.innerHeight;

const ctx = canvas.getContext("2d");

const renderer = new Renderer();

loadImage("./img/sprite.png").then((image) => {
  const spriteSheet = loadSprite(image);

  const street = new Street();

  spriteSheet.draw(ctx, street);
});
