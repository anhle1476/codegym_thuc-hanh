class ElectricLamp {
  constructor() {
    this.turnOn();
  }

  turnOn() {
    this.status = true;
  }

  turnOff() {
    this.status = false;
  }
}

class SwitchButton {
  constructor() {
    this.status = true;
    this.lamp;
  }

  connectToLamp(electricLamp) {
    this.lamp = electricLamp;
    console.log("connected");
  }

  switchOn() {
    this.status = true;
    this.lamp.turnOn();
    console.log("on");
  }

  switchOff() {
    this.status = false;
    this.lamp.turnOff();
    console.log("off");
  }
}

const lamp = new ElectricLamp();
const switchBtn = new SwitchButton();

function logStatus() {
  console.log(`SwitchBtn: ${switchBtn.status}; Lamp: ${lamp.status}`);
}

switchBtn.connectToLamp(lamp);

for (let i = 0; i < 10; i++) {
  if (i % 2 === 0) {
    switchBtn.switchOff();
  } else {
    switchBtn.switchOn();
  }
  logStatus();
}
