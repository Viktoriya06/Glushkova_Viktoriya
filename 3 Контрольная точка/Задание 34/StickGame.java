import java.util.Scanner;

public class StickGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество палочек (n): ");
        long n = scanner.nextLong();

        long tanyaSticks = calculateTanyaSticks(n);
        System.out.println("Количество палочек у Тани: " + tanyaSticks);
    }

    public static long calculateTanyaSticks(long n) {
        long tanyaSticks = 0;

        // Игра начинается с Тани
        boolean isTanyaTurn = true;

        while (n > 0) {
            if (isTanyaTurn) {
                // Тане нужно забрать палочки
                if (n % 2 == 0) {
                    // Если четное, она может взять 1 или n/2
                    tanyaSticks += 1; // Она забирает 1 палочку
                    n -= 1; // Уменьшаем количество палочек
                } else {
                    // Если нечетное, она может взять только 1
                    tanyaSticks += 1; // Она забирает 1 палочку
                    n -= 1; // Уменьшаем количество палочек
                }
            } else {
                // Саша забирает палочки
                if (n % 2 == 0) {
                    // Если четное, он забирает n/2
                    n /= 2; // Уменьшаем количество палочек
                } else {
                    // Если нечетное, он забирает 1
                    n -= 1; // Уменьшаем количество палочек
                }
            }
            // Меняем ход
            isTanyaTurn = !isTanyaTurn;
        }

        return tanyaSticks;
    }
}
