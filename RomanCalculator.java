import java.util.Locale;
import java.util.Scanner;

public class GeneralCalculator {

    private static final String[] ROMAN_NUMBERS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] ARABIC_NUMBERS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    private static boolean isRomanNumber(String number) {
        return number.matches("[IXVXLCDM]+");
    }

    private static boolean isRomanExpression(String expression) {
        String[] tokens = expression.split(" ");
        return isRomanNumber(tokens[0]) && isRomanNumber(tokens[2]);
    }

    private static boolean isArabicNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isArabicExpression(String expression) {
        String[] tokens = expression.split(" ");
        return isArabicNumber(tokens[0]) && isArabicNumber(tokens[2]);
    }

    public static String toRoman(int n) {

        int remainingValue = n;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < ARABIC_NUMBERS.length; i++) {
            while (remainingValue >= ARABIC_NUMBERS[i]) {
                remainingValue -= ARABIC_NUMBERS[i];
                result.append(ROMAN_NUMBERS[i]);
            }
        }

        return result.toString();
    }

    public static int fromRoman(String romanNumeral) {
        String remainingValue = romanNumeral;
        int result = 0;

        for (int i = 0; i < ROMAN_NUMBERS.length; i++) {
            while (remainingValue.startsWith(ROMAN_NUMBERS[i])) {
                remainingValue = remainingValue.substring(ROMAN_NUMBERS[i].length());
                result += ARABIC_NUMBERS[i];
            }
        }
        return result;
    }

    public static String RomanCalculator(String romanExpression) {
        String[] tokens = romanExpression.split(" ");

        if (tokens.length != 3) {
            throw new IllegalArgumentException("Некорректное выражение");
        }

        int firstOperand = fromRoman(tokens[0]);
        int secondOperand = fromRoman(tokens[2]);
        if (firstOperand < 1 || firstOperand > 10 || secondOperand < 1 || secondOperand > 10) {
            throw new IllegalArgumentException("Числа должны быть в диапазоне от 0 до 10");
        }
        int result;
        String operator = tokens[1];
        switch (operator) {
            case "+" -> result = firstOperand + secondOperand;
            case "-" -> result = firstOperand - secondOperand;
            case "*" -> result = firstOperand * secondOperand;
            case "/" -> {
                if (secondOperand == 0) {
                    throw new ArithmeticException("Деление на ноль");
                }
                result = firstOperand / secondOperand;
            }
            default -> throw new IllegalArgumentException("Некорректный оператор");
        }

        if (result <= 0) {
            throw new IllegalArgumentException("Результат работы калькулятора с римскими числами должен быть положительным");
        }

        return toRoman(result);
    }

    public static String ArabicCalculator(String arabicExpression) {
        String[] tokens = arabicExpression.split(" ");
        if (tokens.length != 3) {
            throw new IllegalArgumentException("Некорректное выражение");
        }

        int firstOperand, secondOperand;
        try {
            firstOperand = Integer.parseInt(tokens[0]);
            secondOperand = Integer.parseInt(tokens[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Некорректные числа");
        }
        if (firstOperand < 1 || firstOperand > 10 || secondOperand < 1 || secondOperand > 10) {
            throw new IllegalArgumentException("Числа должны быть в диапазоне от 1 до 10");
        }

        int result;
        String operator = tokens[1];
        switch (operator) {
            case "+" -> result = firstOperand + secondOperand;
            case "-" -> result = firstOperand - secondOperand;
            case "*" -> result = firstOperand * secondOperand;
            case "/" -> {
                if (secondOperand == 0) {
                    throw new ArithmeticException("Деление на ноль");
                }
                result = firstOperand / secondOperand;
            }
            default -> throw new IllegalArgumentException("Некорректный оператор");
        }

        return String.valueOf(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение: ");
        String stringArithmeticExpression = scanner.nextLine();

        String result;
        if (isRomanExpression(stringArithmeticExpression)) {
            result = RomanCalculator(stringArithmeticExpression);
        } else if (isArabicExpression(stringArithmeticExpression)) {
            result = ArabicCalculator(stringArithmeticExpression);
        } else {
            System.out.println("Некорректное выражение. Возможно, вы ввели римское число из нижнего регистра или поставили перед римским числом знак '-', что недопустимо");
            return;
        }

        System.out.println("Результат: " + result);
    }
}
