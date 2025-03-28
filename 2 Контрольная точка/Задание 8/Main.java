import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();

        int upperCount = 0;
        int lowerCount = 0;


        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCount++;
            } else if (Character.isLowerCase(c)) {
                lowerCount++;
            }
        }

        String result;
        if (upperCount > lowerCount) {
            result = input.toUpperCase();
        } else if (lowerCount > upperCount) {
            result = input.toLowerCase();
        } else {
            result = input.toLowerCase();
        }

        System.out.println("Результат: " + result);
    }
}