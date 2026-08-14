import java.lang.reflect.AnnotatedArrayType;

public class Main {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};  // Should give an answer of '10'
        int sumOfIntegers = sum(arr, arr.length);
        System.out.println(sumOfIntegers);

    }

    // ---------------------------- sum function ----------------------------
    public static int sum(int[] numbers, int size) {
        // Special case
        // This will be triggered when the client wants the
        // factorial of a negative integer
        final int ARRAY_LENGTH = numbers.length;  // the size of the collection
        if ( (size < 0) || (size > ARRAY_LENGTH) ) {
            throw new IllegalArgumentException("Your length is not valid. " +
                    "It cannot be negative. " +
                    "It must also be the length or less of your collection.");
        }

        // This is the base case or the most trivial case
        // which does not require any hard-work
        if (size == 0) {
            return 0;
        }

        // This is the recursive space
        else {
            int lastNumber = numbers[size - 1]; // sum
            int nextNumber = sum(numbers, size - 1);
            return lastNumber + nextNumber;
        }
    }
}
