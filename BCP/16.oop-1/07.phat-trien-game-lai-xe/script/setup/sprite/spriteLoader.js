import SpriteSheet from "./SpriteSheet.js";

function loadObjectsToSprite(spriteSheet) {
  spriteSheet.define("street", 0, 0, 646, 898);
  spriteSheet.define("start", 0, 903, 538, 54);
  spriteSheet.define("trunk", 0, 961, 460, 65);
  spriteSheet.define("coin", 485, 976, 48, 48);
  spriteSheet.define("car", 556, 910, 78, 185);
}

export function loadSprite(image) {
  const spriteSheet = new SpriteSheet(image);

  loadObjectsToSprite(spriteSheet);

  return spriteSheet;
}
