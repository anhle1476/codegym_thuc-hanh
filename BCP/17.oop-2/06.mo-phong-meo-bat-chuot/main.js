class Animal {
  constructor(name, weight, speed, words) {
    this.name = name;
    this.weight = weight;
    this.speed = speed;
    this.words = words;
  }

  say() {
    console.log(`[${this.name}] ${this.words}`);
  }

  getWeight() {
    return this.weight;
  }

  getSpeed() {
    return this.speed;
  }

  getName() {
    return this.name;
  }
}

class Rat extends Animal {
  constructor(name, weight, speed) {
    super(name, weight, speed, "chit chit");
    this.state = true;
  }

  isAlive() {
    return this.state;
  }

  dead() {
    this.say();
    this.state = false;
  }
}

class Cat extends Animal {
  constructor(name, weight, speed) {
    super(name, weight, speed, "meo meo");
  }

  catch(rat) {
    if (rat.isAlive() && this.speed > rat.getSpeed()) {
      this.say();
      this.eat(rat);
    }
  }

  eat(rat) {
    rat.dead();
    this.weight += rat.getSpeed();
  }
}

function randomLimit(min, max) {
  return Math.floor(Math.random() * (max - min + 1)) + min;
}

const cat = new Cat("Tom", 500, 75);

console.log(`${cat.getName()}'s weight: ${cat.getWeight()} `);

let rats = [];

for (let i = 0; i < 10; i++) {
  let rat = new Rat(`Mouse ${i}`, randomLimit(2, 5), randomLimit(50, 100));

  rats.push(rat);
}

rats.forEach((rat) => {
  cat.catch(rat);
});

rats.forEach((rat) => {
  if (rat.isAlive()) console.log(rat.getName() + " is alive");
});

console.log(`${cat.getName()}'s weight: ${cat.getWeight()} `);
