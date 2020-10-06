import Speed from "../speed/Speed.js";
import Layer from "./Layer.js";

export default class MovingLayer extends Layer {
  constructor(spriteSheet) {
    super(spriteSheet);
    this.gameSpeed = new Speed();
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
