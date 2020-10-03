// product DOM variables
const newProductDOM = document.getElementById("new-product");
const numberOfProductsDOM = document.getElementById("number-of-products");
const productsDOM = document.getElementById("products");

// modal DOM variables
const modalDOM = document.getElementById("modal");
const modalInputDOM = document.getElementById("modal-input");
const modalCancelDOM = document.getElementById("modal-cancel");

// regex
const EMPTY_REGEX = /^[ \-_]*$/;
const LEGAL_REGEX = /^[\w \-]*$/;

// regex tester
const isInputValid = (input) => {
  if (EMPTY_REGEX.test(input)) {
    alert("Do not leave product name empty");
    return false;
  }

  if (!LEGAL_REGEX.test(input)) {
    alert('Only accept words, numbers, space and "-", "_"!');
    return false;
  }

  return true;
};

// product controller
const productController = {
  add: function (product) {
    // create product container
    const productContainer = document.createElement("div");
    productContainer.classList.add("product");

    // add inner elements-> add product to list
    productContainer.innerHTML = `<span class="product-name">${product}</span><div><button class="edit">Edit</button><button class="delete">Delete</button></div>`;

    productsDOM.appendChild(productContainer);
    this.updateNumberOfProducts();
  },

  delete: function (target) {
    if (confirm("Do you want to remove this product?")) {
      productsDOM.removeChild(target.parentNode.parentNode);
    }
    this.updateNumberOfProducts();
  },

  edit: function (target) {
    const productNameDOM = target.parentNode.previousElementSibling;
    modalController.show(productNameDOM);
  },

  updateNumberOfProducts: function () {
    const numberOfProducts = productsDOM.children.length;
    numberOfProductsDOM.innerText =
      numberOfProducts + (numberOfProducts < 2 ? " product" : " products");
  },
};

// modal controller
const modalController = {
  target: null,
  show: function (target) {
    this.target = target;

    modalInputDOM.value = target.innerText;
    modalDOM.classList.add("show");
  },

  hide: function () {
    this.target = null;

    modalDOM.classList.remove("show");
  },

  submit: function () {
    const newValue = modalInputDOM.value;

    if (isInputValid(newValue)) {
      console.log("ok");
      this.target.innerText = modalInputDOM.value;
      this.hide();
    }
  },
};

// action handlers
const actionHandlers = {
  addProduct: function (e) {
    e.preventDefault();
    let input = newProductDOM.value;

    if (isInputValid(input)) {
      productController.add(input);
      newProductDOM.value = "";
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

// event listener
document
  .getElementById("add-product")
  .addEventListener("submit", actionHandlers.addProduct);
document
  .getElementById("products")
  .addEventListener("click", actionHandlers.clickProductsArea);
document
  .getElementById("modal-form")
  .addEventListener("submit", actionHandlers.modalSubmit);
document
  .getElementById("modal-cancel")
  .addEventListener("click", actionHandlers.modalCancel);
