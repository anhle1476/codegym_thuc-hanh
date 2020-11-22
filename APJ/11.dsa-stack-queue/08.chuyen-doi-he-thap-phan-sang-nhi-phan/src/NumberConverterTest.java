public class NumberConverterTest {
    public static void main(String[] args) {
        int inDecimal = 254166;

        String inBinary = NumberConverter.fromDecimalToBinary(inDecimal);
        System.out.println(inDecimal + " in Binary: " + inBinary);
        System.out.println(inBinary + " in Decimal: " + NumberConverter.fromBinaryToDecimal(inBinary));

        String inHex = NumberConverter.fromDecimalToHex(inDecimal);
        System.out.println(inDecimal + " in Hex: " + inHex);
        System.out.println(inHex + " in Decimal: " + NumberConverter.fromHexToDecimal(inHex));
    }
}
