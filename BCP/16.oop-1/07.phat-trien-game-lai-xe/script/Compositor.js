export default class Compositor {
  constructor(ctx) {
    this.ctx = ctx;
    this.layers = [];
  }

  addLayer(layer) {
    this.layers.push(layer);
  }

  updateLayers() {
    this.layers.forEach((layer) => {
      layer.updateObjects();
    });
  }

  drawLayers() {
    this.layers.forEach((layer) => layer.drawObjects(this.ctx));
  }

  run() {
    this.updateLayers();
    this.drawLayers();
  }
}
