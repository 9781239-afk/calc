import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Калькулятор. Формат: a op b (например: 3 * 4). 'exit' — выход.");
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                String line = sc.nextLine();
                if (line.trim().isEmpty() || line.trim().equalsIgnoreCase("exit")) break;
                System.out.println(calc(line));
            }
        }
    }

    public static String calc(String input) {
        String[] parts = input.trim().split("\\s+");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Ожидаю формат: a op b (например: 3 * 4)");
        }

        int a;
        int b;
        try {
            a = Integer.parseInt(parts[0]);
            b = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Числа должны быть целыми: " + parts[0] + " и " + parts[2]);
        }
        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new IllegalArgumentException("Числа должны быть от 1 до 10 включительно");
        }

        String op = parts[1];
        int result;
        switch (op) {
            case "+" -> result = a + b;
            case "-" -> result = a - b;
            case "*" -> result = a * b;
            case "/" -> {
                if (b == 0) throw new IllegalArgumentException("Деление на ноль");
                result = a / b; // целочисленное деление
            }
            default -> throw new IllegalArgumentException("Неизвестная операция: " + op);
        }
        return String.valueOf(result);
    }
}