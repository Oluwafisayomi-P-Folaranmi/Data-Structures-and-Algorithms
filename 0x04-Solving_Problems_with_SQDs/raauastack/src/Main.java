import Stack.ArrayStack;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Integer[] numbers = {1, 2, 3, 4, 5};
        final int ARRAY_LENGTH = numbers.length;
        System.out.println("Array before reversal -> " + Arrays.toString(numbers));

        ArrayStack<Integer> integerArrayStack;
        integerArrayStack = new ArrayStack<Integer>(5);

        for (int index = 0; index < ARRAY_LENGTH; index++) {
            integerArrayStack.push(numbers[index]);
        }

        // Reversing the array
        for(int index = 0; index < ARRAY_LENGTH; index++) {
            numbers[index] = integerArrayStack.pop();
        }

        System.out.println("Array after reversal -> " + Arrays.toString(numbers));
    }
}
