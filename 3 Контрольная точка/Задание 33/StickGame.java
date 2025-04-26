import java.util.Scanner;

public class StickGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество палочек (n): ");
        long n = scanner.nextLong();

        String winner = determineWinner(n);
        System.out.println("Победитель: " + winner);
    }

    public static String determineWinner(long n) {
        // Если количество палочек четное, игрок может взять 1 или n/2
        // Если количество палочек нечетное, игрок может взять только 1
        return (n % 2 == 0) ? "Второй игрок" : "Первый игрок";
    }
}
