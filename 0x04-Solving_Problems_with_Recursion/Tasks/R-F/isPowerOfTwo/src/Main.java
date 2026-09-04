public class Main {
    public static void main(String[] args) {
        int number = 10;
        System.out.println("Here, '" + number + "' is" +
                " a power of 2 -> '" + isPowerOfTwo(number) + "'");
    }

    public static boolean isPowerOfTwo(int n) {

        // Test the most trivial case
        // This must come before the check of Special case
        if (n == 1) {
            return true;
        }

        // Special case:
        // Check if n is divisible by 2
        if (n % 2 != 0) {
            return false;
        }

        // The recursive call
        boolean fOfX = isPowerOfTwo(n/2);
        return fOfX;
    }
}
