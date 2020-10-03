const countAppearance = (str, strArr) => {
  const times = strArr.filter((val) => val === str).length;

  return times === 0 ? -1 : times;
};

console.log(countAppearance("a", ["a", "b", "d", "a", "e"]));
console.log(countAppearance("z", ["a", "b", "d", "a", "e"]));
