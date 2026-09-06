public class Main {
    public static void main(String[] args) {

        int[] nums = {0,0,1,1,1,2,2,3,4,5,5,6};
        int val = 2;
        int k = removeElement(nums, val);
        System.out.println(k);

    }

    public static int removeElement(int[] nums, int val) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
