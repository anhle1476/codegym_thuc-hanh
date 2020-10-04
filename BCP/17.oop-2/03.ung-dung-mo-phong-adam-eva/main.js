class Human {
  constructor(name, gender, weight) {
    this.setName(name);
    this.setGender(gender);
    this.setWeight(weight);
  }

  setName(name) {
    this.name = name;
  }

  setGender(gender) {
    this.gender = gender;
  }

  setWeight(weight) {
    this.weight = weight;
  }

  getName() {
    return this.name;
  }

  isMale() {
    return this.gender;
  }

  getWeight() {
    return this.weight;
  }

  say(str) {
    console.log(str);
  }

  checkApple(apple) {
    return !apple.isEmpty();
  }

  eat(apple) {
    if (this.checkApple(apple)) {
      apple.decrease();
      this.weight++;
      this.say("Yummy!");
    } else {
      this.say("There is no more apple");
    }
  }
}

class Apple {
  constructor() {
    this.weight = 10;
  }

  isEmpty() {
    return this.weight === 0;
  }

  decrease() {
    this.weight--;
  }

  getWeight() {
    return this.weight;
  }
}

// story
const adam = new Human("Adam", true, 70);
const eva = new Human("Eva", false, 50);
const apple = new Apple();

function logWeight() {
  console.log(
    `Adam: ${adam.getWeight()}; Eva: ${eva.getWeight()}; Apple: ${apple.getWeight()}`
  );
}

logWeight();

for (let i = 0; i < 11; i++) {
  if (i % 2 === 0) {
    adam.eat(apple);
  } else {
    eva.eat(apple);
  }
}

logWeight();
