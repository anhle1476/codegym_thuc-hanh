import { loadImage } from "./loader.js";
import { initialSetup } from "./initialSetup.js";

const ctx = document.getElementById("canvas").getContext("2d");

loadImage("./img/sprite.png").then((image) => {
  const [game, compositor, collisionDetector] = initialSetup(image, ctx);

  function gameLoop() {
    if (game.isEnd) {
      return alert(`Score: ${game.score}`);
    }

    compositor.run();
    collisionDetector.run();

    requestAnimationFrame(gameLoop);
  }

  gameLoop();
});

// Draw chain:
// -> compositor draw
// drawLayers() => layer.drawObj(this.ctx)

// -> layer draw
// drawObjects(ctx) => obj.draw(ctx, this.spriteSheet)

// -> object draw
// draw(ctx, spriteSheet) => spriteSheet.draw(ctx, obj);
