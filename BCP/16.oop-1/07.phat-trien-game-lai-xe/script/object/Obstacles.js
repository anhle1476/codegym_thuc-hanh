import TrunksAndCoin from "./base/TrunksAndCoin.js";

export default class Obstacles {
  constructor() {
    this.obstaclesList = [this.getNewObstacle()];
  }

  _randomPosition() {
    return Math.floor(Math.random() * 346) - 410;
  }

  getNewObstacle() {
    return new TrunksAndCoin(this._randomPosition(), -70);
  }

  generateLastObstacle() {
    const length = this.obstaclesList.length;
    if (length < 3 && this.obstaclesList[length - 1].baseY > 280) {
      this.obstaclesList.push(this.getNewObstacle());
    }
  }

  removeFirstObstacle() {
    if (this.obstaclesList[0].baseY > 850) {
      this.obstaclesList.shift();
    }
  }

  update(speed) {
    this.obstaclesList.forEach((obstacle) => obstacle.update(speed));

    this.generateLastObstacle();
    this.removeFirstObstacle();
  }

  draw(ctx, spriteSheet) {
    this.obstaclesList.forEach((obstacle) => obstacle.draw(ctx, spriteSheet));
  }
}
