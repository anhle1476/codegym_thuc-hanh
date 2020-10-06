export default class Game {
  constructor() {
    this.startNewGame();
  }

  startNewGame() {
    this.isEnd = false;
    this.score = 0;
  }

  endGame() {
    this.isEnd = true;
  }

  increaseScore() {
    this.score++;
  }
}
