import java.util.Scanner;

public class TextTransformer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст:");
        String inputText = scanner.nextLine();

        String transformedText = transformText(inputText);
        System.out.println("Измененный текст:");
        System.out.println(transformedText);
    }

    private static String transformText(String text) {
        StringBuilder result = new StringBuilder();
        String[] words = text.split(" ");

        for (String word : words) {
            if (word.length() > 1 && Character.isLetter(word.charAt(0))) {
                String transformedWord = word.substring(1) + word.charAt(0) + "ауч";
                result.append(transformedWord).append(" ");
            } else {
                result.append(word).append(" ");
            }
        }

        return result.toString().trim();
    }
}


