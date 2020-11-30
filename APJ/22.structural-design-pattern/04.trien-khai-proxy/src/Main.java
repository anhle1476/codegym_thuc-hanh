public class Main {

    public static void main(String[] args) {
        MathCalculatorProxy calculatorProxy = new MathCalculatorProxy();
        double result = calculatorProxy.add(1, 2);
        System.out.println("1 + 2 = " + result);
        result = calculatorProxy.add(2, Double.MAX_VALUE);
        System.out.println("2 + Double.MAX_VALUE = " + result);
    }
    
}
