import Layer from "./Layer.js";

export default class UpperLayer extends Layer {
  constructor(spriteSheet) {
    super(spriteSheet);
  }

  updateObjects() {
    this.objects.forEach((obj) => {
      obj.update();
    });
  }

  drawObjects(ctx) {
    this.objects.forEach((obj) => {
      this.spriteSheet.draw(ctx, obj);
    });
  }
}
