import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Calculator {
    private static final String HISTORY_FILE = "history.txt";
    private static List<String> history = new ArrayList<>();

    public static void main(String[] args) {
        loadHistory();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в калькулятор!");
        System.out.println("Введите выражение для вычисления или 'history' для просмотра истории, 'exit' для выхода.");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.equalsIgnoreCase("history")) {
                printHistory();
            } else if (!input.isEmpty()) {
                try {
                    double result = evaluateExpression(input);
                    String record = input + " = " + result;
                    System.out.println(record);
                    saveToHistory(record);
                } catch (Exception e) {
                    System.out.println("Ошибка в выражении: " + e.getMessage());
                }
            }
        }

        scanner.close();
        System.out.println("Выход. До свидания!");
    }

    // Загружаем историю из файла
    private static void loadHistory() {
        try (BufferedReader br = new BufferedReader(new FileReader(HISTORY_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                history.add(line);
            }
        } catch (IOException e) {
        }
    }

    // Сохраняем запись в историю
    private static void saveToHistory(String record) {
        history.add(record);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(HISTORY_FILE, true))) {
            bw.write(record);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении истории: " + e.getMessage());
        }
    }

    // Вывод истории
    private static void printHistory() {
        if (history.isEmpty()) {
            System.out.println("История пуста.");
        } else {
            System.out.println("История вычислений:");
            for (String record : history) {
                System.out.println(record);
            }
        }
    }

    // Оценка выражения
    private static double evaluateExpression(String expr) throws Exception {
        // Уберем все пробелы для удобства
        expr = expr.replaceAll("\\s+", "");

        // Обработка модуля |k|
        expr = processAbsoluteValues(expr);

        // Обработка возведения в степень (^)
        expr = processOperators(expr, "\\^", (a, b) -> Math.pow(a, b));

        // После этого осталось только +, -, *, /, //, %
        return evaluateSimpleExpression(expr);
    }

    // Обработка абсолютных значений |k|
    private static String processAbsoluteValues(String expr) throws Exception {
        Pattern pattern = Pattern.compile("\\|([^|]+)\\|");
        Matcher matcher = pattern.matcher(expr);
        while (matcher.find()) {
            String inside = matcher.group(1);
            double value = evaluateSimpleExpression(inside);
            double absValue = Math.abs(value);
            expr = expr.replaceFirst(Pattern.quote("|" + inside + "|"), Double.toString(absValue));
            matcher = pattern.matcher(expr);
        }
        return expr;
    }

    // Обработка операторов с приоритетом (^)
    private static String processOperators(String expr, String operatorRegex, BiOperation operation) throws Exception {
        Pattern pattern = Pattern.compile("(-?\\d+(?:\\.\\d+)?)(?:" + operatorRegex + ")(-?\\d+(?:\\.\\d+)?)");
        Matcher matcher = pattern.matcher(expr);
        while (matcher.find()) {
            String leftStr = matcher.group(1);
            String rightStr = matcher.group(2);
            double left = Double.parseDouble(leftStr);
            double right = Double.parseDouble(rightStr);
            double result = operation.apply(left, right);
            String resultStr = Double.toString(result);
            String toReplace = matcher.group();
            expr = expr.replaceFirst(Pattern.quote(toReplace), resultStr);
            matcher = pattern.matcher(expr);
        }
        return expr;
    }

    // Оценка простого выражения без скобок и операторов ^, |k|
    private static double evaluateSimpleExpression(String expr) throws Exception {
        // Разделение по + и -
        List<Double> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        // Регулярное выражение для поиска чисел и операторов
        Pattern pattern = Pattern.compile("([+-]?\\d+(?:\\.\\d+)?|[+\\-*/%])");
        Matcher matcher = pattern.matcher(expr);

        int index = 0;
        while (matcher.find()) {
            String token = matcher.group(1);
            if (token.matches("[+\\-*/%]")) {
                operators.add(token.charAt(0));
            } else {
                numbers.add(Double.parseDouble(token));
            }
            index++;
        }

        for (int i = 0; i < operators.size(); ) {
            char op = operators.get(i);
            if (op == '*' || op == '/' || op == '%' || (op == '-' && (i == 0 || operators.get(i - 1) == '+' || operators.get(i - 1) == '-'))) {
                double a = numbers.get(i);
                double b = numbers.get(i + 1);
                double res;
                switch (op) {
                    case '*':
                        res = a * b;
                        break;
                    case '/':
                        if (b == 0) throw new Exception("Деление на ноль");
                        res = a / b;
                        break;
                    case '%':
                        if (b == 0) throw new Exception("Деление по модулю на ноль");
                        res = a % b;
                        break;
                    case '-':
                        res = a - b;
                        break;
                    default:
                        res = 0; // Не должно случиться
                }
                // Заменяем числа и операцию
                numbers.set(i, res);
                numbers.remove(i + 1);
                operators.remove(i);
            } else {
                i++;
            }
        }

        // Обработка сложения и вычитания
        double result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            char op = operators.get(i);
            double b = numbers.get(i + 1);
            switch (op) {
                case '+':
                    result += b;
                    break;
                case '-':
                    result -= b;
                    break;
            }
        }

        return result;
    }

    @FunctionalInterface
    interface BiOperation {
        double apply(double a, double b) throws Exception;
    }
}
