import java.util.Scanner;

class RomanToArabicConverter {

    public static int toArabic(String roman) {
        if (roman == null || roman.isEmpty()) {
            throw new IllegalArgumentException("Римская цифра не может быть нулевой или пустой.");
        }

        roman = roman.toUpperCase();
        int result = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            char currentChar = roman.charAt(i);
            int currentValue = getValue(currentChar);

            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
            prevValue = currentValue;
        }

        if (result <= 1 || result >= 10000) {
            throw new IllegalArgumentException("Римская цифра должна обозначать число от 2 до 9999");
        }

        if (!toRoman(result).equals(roman)) {
            throw new IllegalArgumentException("Неверный формат римских цифр.");
        }

        return result;
    }

    private static int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default:
                throw new IllegalArgumentException("Неверный символ римской цифры: " + c);
        }
    }

    public static String toRoman(int num) {
        if (num <= 1 || num >= 10000) {
            throw new IllegalArgumentException("Число должно быть от 2 до 9999");
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
        System.out.print("Введите римское число (от 2 до 9999): ");

        try {
            String romanYear = scanner.nextLine();
            int arabicYear = toArabic(romanYear);
            System.out.println("Арабское число эквивалетное" + romanYear + " равно: " + arabicYear);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

