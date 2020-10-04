class Phone {
  constructor(name) {
    this.name = name;
    this.battery = 100;
    this.isOn = true;
    this.currentMessage = null;
    this.sentBox = {};
    this.receivedBox = {};
  }

  showNotification(message) {
    console.log(`\n[${this.name}] ${message}`);
  }

  isEnoughBattery() {
    if (this.battery <= 0) {
      this.showNotification("Low battery. Please charging!");
      this.powerOff();
      return false;
    }
    return true;
  }

  charging() {
    this.battery = 100;
    this.showNotification(`Charged! Battery: ${this.battery}`);
  }

  useBattery(using) {
    if (this.isPowerOff()) return false;
    using();
    this.battery -= 1;
    this.isEnoughBattery();
    return true;
  }

  isPowerOff() {
    if (!this.isOn)
      this.showNotification("Your Phone is off. Please turn on first!");
    return !this.isOn;
  }

  checkPhonePower() {
    console.log(
      `${this.name} is ${this.isOn ? "on" : "off"} - Battery: ${this.battery}`
    );
  }

  powerOn() {
    this.showNotification("Turning on.");
    if (this.isEnoughBattery()) {
      this.isOn = true;
    }
  }

  powerOff() {
    this.showNotification("Turning off.");
    this.isOn = false;
  }

  writingMessage(content) {
    const feature = () => {
      this.currentMessage = {
        from: this.name,
        content: content,
      };
      this.showNotification("Writing success!");
    };

    return this.useBattery(feature);
  }

  receivingMessage(message) {
    const feature = () => {
      this.showNotification(
        `New message from ${message.from}: ${message.content}`
      );

      if (this.receivedBox[message.from] !== undefined) {
        this.receivedBox[message.from].push(message.content);
      } else {
        this.receivedBox[message.from] = [message.content];
      }
    };

    return this.useBattery(feature);
  }

  sendingMessage(recipient) {
    const feature = () => {
      if (!recipient) return this.showNotification("Recipient invalid!");

      if (recipient.receivingMessage(this.currentMessage)) {
        this.showNotification("Sent!");

        if (this.sentBox[recipient.name] !== undefined) {
          this.sentBox[recipient.name].push(this.currentMessage.content);
        } else {
          this.sentBox[recipient.name] = [this.currentMessage.content];
        }
      } else {
        this.showNotification("Failed to send. Please try again later!");
      }
    };

    return this.useBattery(feature);
  }

  _traverseMessageBox(box) {
    let result = "";

    Object.keys(box).forEach((key) => {
      result += `\n- ${key}:\n`;

      box[key].forEach((message) => {
        result += message + "\n";
      });
    });

    return result;
  }

  showReceivedBox() {
    const feature = () => {
      const messages = this._traverseMessageBox(this.receivedBox);
      this.showNotification("RECEIVED: " + messages);
    };

    return this.useBattery(feature);
  }

  showSentBox() {
    const feature = () => {
      const messages = this._traverseMessageBox(this.sentBox);
      this.showNotification("SENT: " + messages);
    };

    return this.useBattery(feature);
  }
}

// TEST
const iphone = new Phone("iphone");
const nokia = new Phone("nokia");

// for (let i = 0; i < 51; i++) {
//   nokia.writingMessage("spam");
//   nokia.sendingMessage(iphone);
// }

nokia.writingMessage("spam");
nokia.sendingMessage(iphone);

nokia.checkPhonePower();
iphone.checkPhonePower();

nokia.charging();
nokia.powerOn();

nokia.checkPhonePower();

nokia.showSentBox();
iphone.showReceivedBox();
