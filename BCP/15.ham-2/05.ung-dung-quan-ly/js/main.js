import { actionHandlers } from "./actionHandler.js";

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
