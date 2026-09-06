public class Main {
    public static void main(String[] args) {

        int[] nums = {0,0,1,1,1,2,2,3,4,5,5,6};
        int k = removeDuplicates(nums);
        System.out.println(k);

    }

    public static int removeDuplicates(int[] nums) {
        int uniquePosition = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[uniquePosition] = nums[i];
                uniquePosition++;
            }
        }

        return uniquePosition;
    }
}
