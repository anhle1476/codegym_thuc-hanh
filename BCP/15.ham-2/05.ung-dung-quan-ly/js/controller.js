import { DOM_VAR } from "./variables.js";
import { isValid } from "./tester.js";

export const productController = {
  add: function (product) {
    // create product container
    const productContainer = document.createElement("div");
    productContainer.classList.add("product");

    // add inner elements-> add product to list
    productContainer.innerHTML = `<span class="product-name">${product}</span><div><button class="edit">Edit</button><button class="delete">Delete</button></div>`;

    DOM_VAR.products.appendChild(productContainer);
    this.updateNumberOfProducts();
  },

  delete: function (target) {
    if (confirm("Do you want to remove this product?")) {
      DOM_VAR.products.removeChild(target.parentNode.parentNode);
    }
    this.updateNumberOfProducts();
  },

  edit: function (target) {
    modalController.show(target.parentNode.previousElementSibling);
  },

  updateNumberOfProducts: function () {
    const numberOfProducts = DOM_VAR.products.children.length;
    DOM_VAR.numberOfProducts.innerText =
      numberOfProducts + (numberOfProducts < 2 ? " product" : " products");
  },
};

export const modalController = {
  target: null,
  show: function (target) {
    this.target = target;

    DOM_VAR.modalInput.value = target.innerText;
    DOM_VAR.modal.classList.add("show");
  },

  hide: function () {
    this.target = null;
    DOM_VAR.modal.classList.remove("show");
  },

  submit: function () {
    const newValue = DOM_VAR.modalInput.value;

    if (isValid(newValue)) {
      this.target.innerText = DOM_VAR.modalInput.value;
      this.hide();
    }
  },
};
