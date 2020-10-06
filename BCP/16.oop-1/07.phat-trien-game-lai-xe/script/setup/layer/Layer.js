export default class Layer {
  constructor(spriteSheet) {
    this.spriteSheet = spriteSheet;
    this.objects = [];
  }

  addObject(obj) {
    this.objects.push(obj);
  }
}
