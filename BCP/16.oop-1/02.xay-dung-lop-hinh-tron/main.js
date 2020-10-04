class Circle {
  constructor(radius, color = "#000") {
    this.radius = radius;
    this.color = color;
  }

  getRadius() {
    return this.radius;
  }

  getArea() {
    return this.radius * this.radius * Math.PI;
  }

  static Circle() {
    return new Circle(1, "#000");
  }
}

let circle = new Circle(2);

let radius = circle.getRadius();
let area = circle.getArea();

console.log(`radius: ${radius}; area: ${area}`);
