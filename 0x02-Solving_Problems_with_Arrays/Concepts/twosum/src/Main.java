import java.awt.*;

public class Main {

    public static void main(String[] args) {

        /**
         * Given an array of integers `nums` and an integer `target`,
         * return indices of the two numbers such that they add up to
         * `target`.
         *
         * You may assume that:
         * + Each input has exactly one solution.
         * + You may not use the same element twice.
         * + The answer can be returned in any order.
         */

        // TEST 1
        System.out.println("This test shows, '" +
                "Testing only two elements that sum up to target 7'");
        int[] num1 = {2, 5}; // Testing only two elements that sum up to target 7.
        int target1 = 7;
        int[] answer1 = twoSum(num1, target1);
        System.out.println(answer1[0] + ", " + answer1[1] + '\n');

        // TEST 2
        System.out.println("This test shows, '" +
                "Testing a larger array'");
        int[] num2 = {1, 2, 5, 6, 7, 8}; // Testing a larger array.
        int target2 = 7;
        int[] answer2 = twoSum(num2, target2);
        System.out.println(answer2[0] + ", " + answer2[1] + '\n');

        // TEST 3
        System.out.println("This test shows, '" +
                "Testing a no-element array'");
        int[] num3 = {}; // Testing a no-element array.
        int target3 = 7;
        int[] answer3 = twoSum(num3, target3);
        System.out.println(answer3[0] + ", " + answer3[1] + '\n');

        // TEST 4
        System.out.println("This test shows, '" +
                "Testing an array that cannot sum any two elements into the `target`'");
        int[] num4 = {}; // Testing an array that cannot sum any two elements into the `target`.
        int target4 = 10;
        int[] answer4 = twoSum(num4, target4);
        System.out.println(answer4[0] + ", " + answer4[1]);

    }

    public static int[] twoSum(int[] array, int target) {

        int[] result = new int[2];

        for (int i = 0; i < array.length; i++) {

            int currentNumber = array[i];
            int complement = Math.abs(target - currentNumber);

            for (int j = 0; j != i && j < array.length; j++) {

                if (array[j] == complement) {

                    result[1] = i;
                    result[0] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
