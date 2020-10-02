// test case 025468 chỉ đúng với trường hợp dùng promt(), vì giá trị nhận đc vốn đã là String -> vẫn giữ được số 0 ở đầu -> const str = num.toString() là thừa

const joinNumber = (num) => {
  const str = num.toString();
  let result = "";

  for (let i = 0; i < str.length - 1; i++) {
    result += str[i];
    if (parseInt(str[i]) % 2 === 0 && parseInt(str[i + 1]) % 2 === 0) {
      result += "-";
    }
  }
  return result + str[str.length - 1];
};
