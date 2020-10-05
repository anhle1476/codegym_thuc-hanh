class Television {
  constructor() {
    this.status = false;
    this.volume = 50;
    this.setChanel(1);
  }

  setChanel(chanel) {
    this.chanel = chanel;
  }

  changeVolume(num) {
    this.volume += num;
  }

  turnOn() {
    this.status = true;
  }

  turnOff() {
    this.status = false;
  }

  logCurrentChanel() {
    console.log("Chanel: " + this.chanel);
  }

  logStatus() {
    console.log("is Power On: " + this.status);
    return this.status;
  }

  logVolume() {
    console.log("Volume: " + this.volume);
  }

  logCurrentState() {
    if (this.logStatus()) {
      console.log("");
      this.logCurrentChanel();
      this.logVolume();
    }
  }
}

class Remote {
  constructor(tv) {
    this.tv = tv;
  }

  turnOffTV() {
    this.tv.turnOff();
  }

  turnOnTV() {
    this.tv.turnOn();
  }

  getTVState() {
    this.tv.logCurrentState();
  }

  switchChanel(chanel) {
    this.tv.setChanel(chanel);
  }

  changeTVVolume(amount) {
    this.tv.changeVolume(amount);
  }
}

const tv = new Television();
const remote = new Remote(tv);

tv.turnOn();
tv.logCurrentState();

tv.setChanel(7);
tv.logCurrentChanel();

remote.switchChanel(3);
remote.getTVState();

tv.changeVolume(2);
tv.logCurrentChanel();

remote.turnOffTV();
