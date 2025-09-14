package app.operations;

public class Division extends Operation{

    @Override
    public double calculate(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("������� �� ����!");
        }
        return num1 / num2;
    }

}
