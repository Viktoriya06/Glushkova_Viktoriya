import java.util.Scanner;

class RomanConverter {

    public static String toRoman(int num) {
        if (num <= 1 || num >= 10000) {
            throw new IllegalArgumentException("Число должно быть от 2 до 9999.");
        }

        String[] thousands = {"", "M", "MM", "MMM", "MV", "V", "VM", "VMM", "VMMM", "IX"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousands[num / 1000] +
                hundreds[(num % 1000) / 100] +
                tens[(num % 100) / 10] +
                ones[num % 10];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите год (от 2 до 9999): ");

        try {
            int year = scanner.nextInt();
            String romanYear = toRoman(year);
            System.out.println("Римская цифра, эквивалентная " + year + " равна: " + romanYear);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Неверный ввод. Пожалуйста, введите целое число.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

