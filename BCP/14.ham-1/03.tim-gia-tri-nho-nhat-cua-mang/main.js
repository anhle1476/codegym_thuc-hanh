function minArray(arr) {
  if (arr.length == 0) return -1;

  let min = arr[0];
  let index = 0;

  for (let i = 1; i < arr.length; i++) {
    if (arr[i] < min) {
      min = arr[i];
      index = i;
    }
  }

  console.log(`Min: ${min} - Index: ${index}`);
  return index;
}

let arr1 = [3, 5, 1, 8, -3, 7, 8];
let arr2 = [7, 12, 6, 9, 20, 56, 89];
let arr3 = [];
let arr4 = [0, 0, 0, 0, 0, 0];

minArray(arr1);
minArray(arr2);
minArray(arr3);
minArray(arr4);
