import java.util.Arrays;
import java.util.Scanner;

public class MemoryCell {
    private Integer[] numbers;
    private final int MAX_SIZE = 3;

    public MemoryCell() {
        numbers = new Integer[MAX_SIZE];
    }

    public void addNumber(int number) {

        for (int i = 0; i < MAX_SIZE; i++) {
            if (numbers[i] == null) {
                numbers[i] = number;
                return;
            }
        }

        replaceSmallest(number);
    }

    private void replaceSmallest(int number) {
        int minIndex = 0;


        for (int i = 1; i < MAX_SIZE; i++) {
            if (numbers[i] < numbers[minIndex]) {
                minIndex = i;
            }
        }


        numbers[minIndex] = number;
    }

    public void displayNumbers() {
        System.out.println("Содержимое ячейки памяти: " + Arrays.toString(numbers));
    }

    public static void main(String[] args) {
        MemoryCell memory = new MemoryCell();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите число (или '-1' для выхода): ");
            int input = scanner.nextInt();

            if (input == -1) {
                break;
            }

            memory.addNumber(input);
            memory.displayNumbers();
        }

        scanner.close();
    }
}