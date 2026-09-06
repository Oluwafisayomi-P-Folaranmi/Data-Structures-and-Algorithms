public class Main {
    public static void main(String[] args) {

        int[] nums = {0,1,2,3,4,5,6,7,8,9};
        int target = 2;
        int k = searchInsert(nums, target);
        System.out.println(k);

    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
