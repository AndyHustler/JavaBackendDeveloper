package app.operations;

public class Remainder extends Operation{

    @Override
    public double calculate(double num1, double num2) {
        return num1 % num2;
    }

}
