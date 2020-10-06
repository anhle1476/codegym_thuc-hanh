import Layer from "./Layer.js";

export default class MovingLayer extends Layer {
  constructor(spriteSheet, speed) {
    super(spriteSheet);
    this.gameSpeed = speed;
  }

  updateObjects() {
    this.gameSpeed.update();

    this.objects.forEach((obj) => {
      obj.update(this.gameSpeed.speed);
    });
  }

  drawObjects(ctx) {
    this.objects.forEach((obj) => {
      obj.draw(ctx, this.spriteSheet);
    });
  }
}
