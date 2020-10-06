export default class SpriteSheet {
  constructor(image) {
    this.image = image;
    this.sprites = new Map();
  }

  define(name, sX, sY, sWidth, sHeight) {
    this.sprites.set(name, {
      sX: sX,
      sY: sY,
      sW: sWidth,
      sH: sHeight,
    });
  }

  draw(ctx, obj) {
    const { sX, sY, sW, sH } = this.sprites.get(obj.name);
    ctx.drawImage(
      this.image,
      sX,
      sY,
      sW,
      sH,
      obj.x,
      obj.y,
      obj.width,
      obj.height
    );
  }
}
