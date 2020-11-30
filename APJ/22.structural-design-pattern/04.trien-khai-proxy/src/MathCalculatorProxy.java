public class MathCalculatorProxy implements Calculator {
    private final MathCalculator mathCalculator;

    public MathCalculatorProxy(){
        this.mathCalculator = new MathCalculator();
    }

    @Override
    public double add(double first, double second) {
        double halfOfValue = first / 2 + second / 2;
        checkHalfValueInSafeRange(halfOfValue);
        return mathCalculator.add(first, second);
    }

    @Override
    public double sub(double first, double second) {
        double halfOfValue = first / 2 - second / 2;
        checkHalfValueInSafeRange(halfOfValue);
        return mathCalculator.sub(first, second);
    }

    @Override
    public double mul(double first, double second) {
        double result = mathCalculator.mul(first, second);
        if(first != 0 && result / first != second){
            throw new RuntimeException("Out of range");
        }
        return result;
    }

    @Override
    public double div(double first, double second) {
        if(second == 0){
            throw new RuntimeException("Can't divide by zero");
        }
        return mathCalculator.div(first, second);
    }

    private void checkHalfValueInSafeRange(double halfOfValue) throws RuntimeException {
        if ( halfOfValue >= Double.MAX_VALUE / 2 || halfOfValue <= Double.MIN_VALUE / 2)
            throw new RuntimeException("Out of range");
    }
}