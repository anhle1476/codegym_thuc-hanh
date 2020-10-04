class Battery {
  constructor(energy) {
    this.setEnergy(energy);
  }

  setEnergy(energy) {
    this.energy = energy;
  }

  getEnergy() {
    return this.energy;
  }

  decreaseEnergy() {
    if (this.energy > 0) {
      this.energy--;
    }
  }
}

class FlashLamp {
  constructor(status, battery) {
    this.status = status;
    this.setBattery(battery);
  }

  setBattery(battery) {
    this.battery = battery;
  }

  getBatteryInfo() {
    return this.battery.getEnergy();
  }

  light() {
    if (this.status) {
      console.log("Lighting");
      this.battery.decreaseEnergy();
    } else {
      console.log("Not lighting");
    }
  }

  turnOn() {
    this.status = true;
  }

  turnOff() {
    this.status = false;
  }
}

let battery = new Battery();
battery.setEnergy(10);

let flashLamp = new FlashLamp();
flashLamp.setBattery(battery);

console.log("Battery info:" + flashLamp.getBatteryInfo() + "\n");
flashLamp.light();

console.log("Turn on\n");
flashLamp.turnOn();
flashLamp.light();
console.log("Battery info:" + flashLamp.getBatteryInfo() + "\n");

console.log("Turn off\n");
flashLamp.turnOff();
flashLamp.light();
