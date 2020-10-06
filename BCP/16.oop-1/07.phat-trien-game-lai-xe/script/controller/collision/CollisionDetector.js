export default class CollisionDetector {
  constructor(game, entity, obstacles) {
    this.setGame(game);
    this.setEntity(entity);
    this.setObstacles(obstacles);
  }

  setGame(game) {
    this.game = game;
  }

  setEntity(entity) {
    this.entity = entity;
  }

  setObstacles(obstacles) {
    this.obstacles = obstacles;
  }

  getSquarePosition(obj) {
    return [obj.x, obj.y, obj.x + obj.width, obj.y + obj.height];
  }

  detectBySquareBounding(
    [entX0, entY0, entX1, entY1],
    [objX0, objY0, objX1, objY1]
  ) {
    return entY1 < objY0 || entY0 > objY1 || entX1 < objX0 || entX0 > objX1
      ? false
      : true;
  }

  run() {
    const entPosition = this.getSquarePosition(this.entity);
    const { trunks, coin } = this.obstacles.getFirstObstacle();

    for (const trunk of trunks) {
      const trunkPosition = this.getSquarePosition(trunk);
      if (this.detectBySquareBounding(entPosition, trunkPosition)) {
        trunk.hit(this.game);
      }
    }

    const coinPosition = this.getSquarePosition(coin);
    if (this.detectBySquareBounding(entPosition, coinPosition)) {
      coin.hit(this.game);
    }
  }
}
