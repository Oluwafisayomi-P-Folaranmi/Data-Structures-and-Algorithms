public class Main {

    public static void main(String[] args) {

        Integer[] num = {1, 2, 5, 6, 7, 8};
        int element = 5;
        Integer[] answer = removeElement(num, element);

        System.out.println(answer);
        for (int i = 0; i < num.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public static Integer[] removeElement(Integer[] array, int element) {

        int k = 0;
        Integer[] result = new Integer[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            if (array[i] != element) {
                result[k] = array[i];
                k++;
            }
        }
        result[result.length - 1] = k;
        return result;
    }
}
