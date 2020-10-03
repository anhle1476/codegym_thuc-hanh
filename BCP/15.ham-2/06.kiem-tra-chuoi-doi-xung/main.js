function leftRightCheck(str, left, right) {
  if (right <= left) return true;
  if (str[left] !== str[right]) return false;

  return leftRightCheck(str, left + 1, right - 1);
}

function isPalindrome(str) {
  return leftRightCheck(str, 0, str.length - 1);
}

// false cases
console.log(isPalindrome("abcdefaedcba"));
console.log(isPalindrome("aac"));
// true cases
console.log(isPalindrome("abcdefedcba"));
console.log(isPalindrome("aa"));
console.log(isPalindrome("a"));
console.log(isPalindrome(""));
