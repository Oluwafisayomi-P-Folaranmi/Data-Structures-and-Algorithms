public class Main {
    public static void main(String[] args) {
        int number = 27;
        System.out.println("Here, '" + number + "' is" +
                " a power of 3 -> '" + isPowerOfThree(number) + "'");
    }

    public static boolean isPowerOfThree(int n) {
        // Base case:
        if (n == 1) {
            return true;
        }

        // Special case:
        // When n is not divisible by 3
        if (n % 3 != 0) {
            return false;
        }

        // The recursive call
        boolean fOfX = isPowerOfThree(n/3);
        return fOfX;
    }
}
