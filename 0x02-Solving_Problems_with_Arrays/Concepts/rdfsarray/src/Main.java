public class Main {

    public static void main(String[] args) {

        Integer[] num = {1, 1, 1, 2, 2, 3, 3, 3, 3, 5, 5, 6, 7, 8, 10, 10, 10};
        Integer[] answer = removeDuplicates(num);
        for (int ans : answer) {
            System.out.print(ans + ", ");
        }

    }

    public static Integer[] removeDuplicates(Integer[] array) {

        Integer[] result = new Integer[array.length - 1];
        int k = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i - 1]) {
                result[k] = array[i];
                k++;
            }
        }

        // Fill `null` elements
        // Number of `null` elements = ...
        for (int i = k; i < (array.length - 1); i++) {
            result[i] = 0;
        }

        return result;
    }
}
