import TrunksAndCoin from "./base/TrunksAndCoin.js";

export default class Obstacles {
  constructor() {
    this.obstaclesList = [this.makeNewObstacle()];
  }

  getFirstObstacle() {
    return this.obstaclesList[0];
  }

  makeNewObstacle() {
    return new TrunksAndCoin(Math.floor(Math.random() * 346) - 410, -70);
  }

  generateLastObstacle() {
    const length = this.obstaclesList.length;
    if (length < 3 && this.obstaclesList[length - 1].baseY > 300) {
      this.obstaclesList.push(this.makeNewObstacle());
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
