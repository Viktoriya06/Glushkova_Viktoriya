import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Введите первую строку:");
        String str1 = scanner.nextLine();

        System.out.println("Введите вторую строку:");
        String str2 = scanner.nextLine();

        // Проверка, является ли str2 окончанием str1
        boolean result = str1.endsWith(str2);


        System.out.println(result);

        scanner.close();
    }
}


