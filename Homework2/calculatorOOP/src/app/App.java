package app;

import java.util.Scanner;
import app.calculator.Calculator;
import app.decoder.Decoder;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hi, i am calculator!");
        System.out.println("I can perform operations with double");
        System.out.println("I can perform the following operations: +, -, *, /");
        System.out.println("I can perform exponentiation operation. Type arg1 ^ arg2");
        System.out.println("I can calculate the remainder of the division. Type arg1 % arg2");
        System.out.println("To exit, type 'exit'");
        while (true) {
            System.out.println("Enter an expression:");
            String exp = sc.nextLine();
            if(exp.equals("exit")) {
                sc.close();
                System.exit(0);
            } else {
                System.out.println(reader(exp));
            }
        }
    }

    private static String reader(String exp) {
        Calculator calculator = new Calculator();
        Decoder decoder = new Decoder(exp);
        try {
            double result = calculator.performOperation(decoder.getOperation(), decoder.getDigits());
            return "Result: " + result;
        } catch (IllegalArgumentException | ArithmeticException e) {
            return "Error: " + e;
        }
    }
}
