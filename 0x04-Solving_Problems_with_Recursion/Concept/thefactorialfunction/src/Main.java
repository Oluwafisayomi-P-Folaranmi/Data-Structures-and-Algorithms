public class Main {
    public static void main(String[] args) {

        int factl = factorial(0);
        System.out.println(factl);
    }

    // ---------------------------- factorial function ----------------------------
    public static int factorial(int number) {
        // Special case
        // This will be triggered when the client wants the
        // factorial of a negative integer
        if (number < 0) {
            throw new IllegalArgumentException("Your number is not valid.");
        }

        // This is the base case or the most trivial case
        // which does not require any hard-work
        if (number == 0) {
            return 1;
        }

        // This is the recursive space
        else {
            int n = number;
            int nextNumber = factorial(n - 1);
            return n * nextNumber;
        }
    }
}
