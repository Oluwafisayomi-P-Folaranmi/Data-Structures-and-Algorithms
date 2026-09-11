import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello.");
    }

    public static String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();

        // Create [1, 2, 3, ..., n]
        for (int number = 1; number <= n; number++) {
            numbers.add(number);
        }

        // Convert k from 1-based to 0-based
        k--;

        return findPermutation(numbers, k);
    }

    private static String findPermutation(List<Integer> numbers, int k) {

        // Base case
        if (numbers.size() == 1) {
            return String.valueOf(numbers.get(0));
        }

        int blockSize = factorial(numbers.size() - 1);

        // Determine which block contains k
        int index = k / blockSize;

        // Select the number from that block
        int selectedNumber = numbers.get(index);

        // Remove the selected number
        numbers.remove(index);

        // Determine k's position within the selected block
        int newK = k % blockSize;

        // Recursively solve the smaller problem
        return selectedNumber + findPermutation(numbers, newK);
    }

    private static int factorial(int number) {
        int result = 1;

        for (int value = 2; value <= number; value++) {
            result *= value;
        }

        return result;
    }
}
