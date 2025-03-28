import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int firstNumber = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int secondNumber = scanner.nextInt();


        int start = Math.min(firstNumber, secondNumber);
        int step = Math.abs(firstNumber - secondNumber);


        for (int i = start; i <= 9 * start; i += step) {
            int square = i * i;
            System.out.print(square + " ");
        }
    }
}