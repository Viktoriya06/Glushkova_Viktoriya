public class SquareDifference {

    public static String findSquares(int n) {
        if (n <= 0 || n > 100000) {
            return "Invalid input";
        }

        for (long i = 1; i * i <= (n + 1) / 2; i++) {
            long jSquared = i * i + n;
            long j = (long) Math.sqrt(jSquared);
            if (j * j == jSquared) {
                return j + "^2 - " + i + "^2";
            }
        }

        return "No solution found";
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println(n + " = " + findSquares(n));

        n = 5;
        System.out.println(n + " = " + findSquares(n));

        n = 7;
        System.out.println(n + " = " +  findSquares(n));
    }
}
