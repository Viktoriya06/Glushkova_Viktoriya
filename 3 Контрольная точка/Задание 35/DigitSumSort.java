import java.util.Arrays;
import java.util.Comparator;

public class DigitSumSort {

    public static String sortWeights(String weights) {
        if (weights == null || weights.isEmpty()) {
            return "";
        }

        String[] weightArray = weights.split(" ");
        Arrays.sort(weightArray, Comparator.comparingInt(DigitSumSort::digitSum).thenComparing(String::compareTo));
        return String.join(" ", weightArray);
    }

    private static int digitSum(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            sum += Character.getNumericValue(number.charAt(i));
        }
        return sum;
    }

    public static void main(String[] args) {
        String weights = "56 65 74 100 99 68 86 180 90";
        String sortedWeights = sortWeights(weights);
        System.out.println("Отсортированный список: " + sortedWeights);
    }
}


