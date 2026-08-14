public class Main {
    public static void main(String[] args) {
        int number = 8;
        System.out.println("Here, '" + number + "' is" +
                " a power of 2 -> '" + isPowerOfTwo(number) + "'");
    }

    public static boolean isPowerOfTwo(int n) {

        // Test the most trivial case
        if (n == 1) {
            return true;
        }

        // Check if n is divisible by 2
        if (n % 2 != 0) {
            return false;
        }

        int lastNumber = n;
        int previousNumberToLastNumber = n /2;
        return isPowerOfTwo(n / 2);
    }
}
