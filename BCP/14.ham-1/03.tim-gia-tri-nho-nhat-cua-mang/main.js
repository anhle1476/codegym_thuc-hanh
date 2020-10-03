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
