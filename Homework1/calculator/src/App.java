import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hi, i am calculator!");
        System.out.println("I can perform operations with integers");
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
                System.out.println(scaner(exp));
            }
        }
    }

    private static String scaner(String exp) {
        if(exp.contains("+") && testExp(exp, "\\+")) return sum(getDigits(exp, "\\+"));
        if(exp.contains("-") && testExp(exp, "-")) return difference(getDigits(exp, "-"));
        if(exp.contains("*") && testExp(exp, "\\*")) return multiply(getDigits(exp, "\\*"));
        if(exp.contains("/") && testExp(exp, "\\/")) return divide(getDigits(exp, "\\/"));
        if(exp.contains("^") && testExp(exp, "\\^")) return exponentiation(getDigits(exp, "\\^"));
        if(exp.contains("%") && testExp(exp, "\\%")) return remainder(getDigits(exp, "\\%"));
        return "Enter a valid expression.";
    }
    //Addition operation
    private static String sum(int[] d) {
        return "Result: " + (d[0] + d[1]);
    }

    //Subtraction operation
    private static String difference(int[] d) {
        return "Result: " + (d[0] - d[1]);
    }

    //Multiplication operation
    private static String multiply(int[] d) {
        return "Result: " + (d[0] * d[1]);
    }

    //Division operation
    private static String divide(int[] d) {
        if(d[1] == 0) return "You can't divide by 0";
        if(d[0] % d[1] > 0) return "Result: " + ((double)d[0] / d[1]);
        return "Result: " + (d[0] / d[1]);
    }

    //Exponentiation operation
    private static String exponentiation(int[] d) {
        return "Result: " + (int)Math.pow(d[0], d[1]);
    }

    //Remainder division operation
    private static String remainder(int[] d) {
        return "Result: " + (d[0] % d[1]);
    }

    //Extracting numbers from a string
    private static int[] getDigits(String exp, String op) {
        int[] d = new int[2];
        String[] s = exp.split(op);
        d[0] = Integer.parseInt(s[0].trim());
        d[1] = Integer.parseInt(s[1].trim());
        return d;
    }

    //Checking if a string has two integer arguments
    private static boolean testExp(String exp, String op) {
        String[] s = exp.split(op);
        if(isDigit(s[0]) && isDigit(s[1])) return true;
        return false;
    }

    //Checking an argument for an integer
    private static boolean isDigit(String s) {
        return s.matches("-?\\d+");
    }
}
