import Street from "./base/Street.js";

export default class RacingStreet {
  constructor() {
    this.HEIGHT = 898;
    this.pieces = [];

    const initial = new Street(0, -50);
    this.pieces.push(initial);
  }

  generatePiece() {
    if (this.pieces[0].y >= -30 && this.pieces.length === 1) {
      this.pieces.push(new Street(0, this.pieces[0].y - 898));
    }
  }

  removeFirstPiece() {
    if (this.pieces[0].y >= 898) {
      this.pieces.shift();
    }
  }

  update(speed) {
    this.pieces.forEach((piece) => piece.increaseY(speed));
    this.generatePiece();
    this.removeFirstPiece();
  }

  draw(ctx, spriteSheet) {
    this.pieces.forEach((piece) => {
      spriteSheet.draw(ctx, piece);
    });
  }
}
