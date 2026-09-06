public class Main {
    public static void main(String[] args) {
        System.out.println("2 ^ 3 is -> '" + myPow(2, 3) + "'");
    }

    public static double myPow(double x, int n) {
        long exponent = n;

        if (exponent < 0) {
            return 1 / power(x, -exponent);
        }

        return power(x, exponent);
    }

    private static double power(double x, long n) {
        if (n == 0) {
            return 1;
        }

        double half = power(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        }

        return half * half * x;
    }
}
