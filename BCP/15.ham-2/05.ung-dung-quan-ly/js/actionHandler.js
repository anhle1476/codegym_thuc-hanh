import { DOM_VAR } from "./variables.js";
import { productController, modalController } from "./controller.js";
import { isValid } from "./tester.js";

export const actionHandlers = {
  addProduct: function (e) {
    e.preventDefault();
    let input = DOM_VAR.newProduct.value;

    if (isValid(input)) {
      productController.add(input);
      DOM_VAR.newProduct.value = "";
    }
  },

  clickProductsArea: function ({ target }) {
    const classList = target.classList;
    if (classList.contains("delete")) {
      productController.delete(target);
    }

    if (classList.contains("edit")) {
      productController.edit(target);
    }
  },

  modalSubmit: function (e) {
    e.preventDefault();
    modalController.submit();
  },

  modalCancel: function () {
    modalController.hide();
  },
};
