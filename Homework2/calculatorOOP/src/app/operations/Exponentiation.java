package app.operations;

public class Exponentiation extends Operation {

    @Override
    public double calculate(double num1, double num2) {
        return Math.pow((int)num1, (int)num2);
    }

}
