
import java.util.Scanner;

public class RomanCalculator {


    private static final String[] ROMAN_NUMBERS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] ARABIC_NUMBERS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};


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

        for(int i = 0; i<ROMAN_NUMBERS.length; i++) {
            while(remainingValue.startsWith(ROMAN_NUMBERS[i])) {
                remainingValue = remainingValue.substring(ROMAN_NUMBERS[i].length(), remainingValue.length());
                result += ARABIC_NUMBERS[i];
            }
        }
        return result;
    }
    public static String RomanCalculator(String input) {
        String[] tokens = input.split(" ");

        if (tokens.length != 3) {
            throw new IllegalArgumentException("Некорректное выражение");
        }

        int firstOperand = fromRoman(tokens[0]);
        int secondOperand = fromRoman(tokens[2]);

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



    public static String ArabicCalculator(String input) {

        String[] tokens = input.split(" ");
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

        int result;
        String operator = tokens[1];
        switch (operator) {
            case "+" -> result = firstOperand + secondOperand;
            case "-" -> result = firstOperand - secondOperand;
            case "*" -> result = firstOperand * secondOperand;
            case "/" -> {
                if (secondOperand == 0) {
                    throw new ArithmeticException("Деление на ноль");
                } result = firstOperand / secondOperand;
            }
            default -> throw new IllegalArgumentException("Некорректный оператор");
        };

        return String.valueOf(result);
    }


    public static void main(String[] args) {
        Scanner input1 = new Scanner(System.in);
        System.out.println("Выберите 1 или 2");
        System.out.println("1.Калькулятор римских цифр");
        System.out.println("2.Калькулятор арабских цифр");
        int chooseVariant = input1.nextInt();

        if (chooseVariant == 1) {
            Scanner input2 = new Scanner(System.in);
            System.out.print("Введите арифметическое выражение римскими цифрами: ");
            String result = RomanCalculator(input2.nextLine());
            System.out.println("Результат: " + result);
        } else if (chooseVariant == 2) {
            Scanner input3 = new Scanner(System.in);
            System.out.print("Введите арифметическое выражение арабскими цифрами: ");
            String result = ArabicCalculator(input3.nextLine());
            System.out.println("Результат: " + result);
        } else System.out.println("Вы неверно выбрали вариант");


    }
}

