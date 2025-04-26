public class SumOfPowers {

    public static boolean sC(int number, int start) {
        String numStr = String.valueOf(number);
        int sum = 0;
        for (int i = 0; i < numStr.length(); i++) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            sum += Math.pow(digit, start + i);
        }

        if (sum % number != 0) return false;

        int factor = sum / number;
        return (factor > 0 && (factor & (factor - 1)) == 0);
    }

    public static void main(String[] args) {
        System.out.println("sC(89, 1) => " + sC(89, 1));
        System.out.println("sC(695, 2) => " + sC(695, 2));
    }
}

