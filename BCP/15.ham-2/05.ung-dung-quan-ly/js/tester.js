const EMPTY_REGEX = /^[ \-_]*$/;
const LEGAL_REGEX = /^[\w \-]*$/;

// regex tester
export const isValid = (input) => {
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
