import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static void main(String[] args) {
        int i = 10;
        long fib = fibonacci(i);
        System.out.println("Fibonacci: " + fib);
        System.out.println("Most frequent digit: " + mostFrequentDigit(fib));
    }

    public static long fibonacci(int n) {
        if (n <= 1) return n;
        long a = 0, b = 1;
        for (int j = 2; j <= n; j++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static Map.Entry<Integer, Integer> mostFrequentDigit(long number) {
        Map<Integer, Integer> digitCount = new HashMap<>();
        while (number > 0) {
            int digit = (int) (number % 10);
            digitCount.put(digit, digitCount.getOrDefault(digit, 0) + 1);
            number /= 10;
        }
        return digitCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);
    }
}

