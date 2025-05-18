public class Fusc {

    public static int fusc(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int a = 0;
        int b = 1;

        while (n > 0) {
            if (n % 2 == 0) {
                b = a + b;
                n /= 2;
            } else {
                a = b;
                b = a + b;
                n /= 2;
            }
        }
        return a;
    }


    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.println("fusc(" + i + ") = " + fusc(i));
        }
    }
}
