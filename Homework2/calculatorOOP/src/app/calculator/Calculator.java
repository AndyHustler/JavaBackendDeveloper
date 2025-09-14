package app.calculator;

import java.util.HashMap;
import java.util.Map;

import app.operations.*;

public class Calculator {
    private Map<String, Operation> operations = new HashMap<>();

    public Calculator() {
        operations.put("\\+", new Addition());
        operations.put("-", new Subtraction());
        operations.put("\\*", new Multiplication());
        operations.put("\\/", new Division());
        operations.put("\\^", new Exponentiation());
        operations.put("\\%", new Remainder());
    }

    public double performOperation(String operator, double[] d) {
        if (operations.containsKey(operator)) {
            return operations.get(operator).calculate(d[0], d[1]);
        } else {
            throw new IllegalArgumentException("Illigal operation: " + operator);
        }
    }
}
