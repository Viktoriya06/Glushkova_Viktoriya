import java.util.Random;
import java.util.Scanner;

public class GuessTheCode {

    public static void main(String[] args) {
        Random random = new Random();
        int[] secretCode = new int[4];
        for (int i = 0; i < 4; i++) {
            secretCode[i] = random.nextInt(10); // Цифры от 0 до 9
        }

        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        System.out.println("Добро пожаловать в игру 'Угадай код'!");

        while (attempts < 20) {
            System.out.print("Попытка " + (attempts + 1) + ": Введите 4 числа через пробел: ");
            String input = scanner.nextLine();
            String[] numbers = input.split(" ");

            if (numbers.length != 4) {
                System.out.println("Необходимо ввести 4 числа.");
                continue;
            }

            try {
                int[] guess = new int[4];
                for (int i = 0; i < 4; i++) {
                    guess[i] = Integer.parseInt(numbers[i]);
                }

                int matches = 0;
                for (int i = 0; i < 4; i++) {
                    if (guess[i] == secretCode[i]) {
                        matches++;
                    }
                }

                if (matches == 4) {
                    System.out.println("Поздравляем! Вы угадали код за " + (attempts + 1) + " попыток.");
                    break;
                } else {
                    System.out.println("Количество совпадений: " + matches);
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода. Введите числа через пробел.");
                continue;
            }

            attempts++;
        }

        if (attempts == 20) {
            System.out.print("Вы исчерпали все попытки. Загаданный код: ");
            for (int digit : secretCode) {
                System.out.print(digit + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
