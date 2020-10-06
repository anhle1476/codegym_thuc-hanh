export default class Renderer {
  constructor() {
    this.objects = [];
  }

  push(obj) {
    this.objects.push(obj);
  }

  draw(ctx) {
    ctx.drawImage(sprite, 0, 0, 646, 898, 0, 0, 647, 898);
  }
}
