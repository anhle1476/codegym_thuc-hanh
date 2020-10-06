import Coin from "./Coin.js";
import Trunk from "./Trunk.js";

export default class TrunksAndCoin {
  constructor(x, y) {
    this.baseY = y;
    this.createObstacle(x, y);
  }

  update(speed) {
    this.baseY += speed;

    this.trunks.forEach((trunk) => trunk.increaseY(speed));
    this.coin.increaseY(speed);
  }

  createObstacle(x, y) {
    this.trunks = [new Trunk(x, y), new Trunk(x + 660, y)];
    this.coin = new Coin(x + 536, y + 9);
  }

  draw(ctx, spriteSheet) {
    this.trunks.forEach((trunk) => spriteSheet.draw(ctx, trunk));
    if (this.coin.isShow) {
      spriteSheet.draw(ctx, this.coin);
    }
  }
}
