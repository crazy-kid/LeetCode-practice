package JAVA.Mid;

public class mid_795 {

    public static void main(String[] args) {
        int[] nums = { 2, 1, 4, 3 };
        int left = 2, right = 3;

        System.out.println(lessThan(nums, right + 1) - lessThan(nums, left));
    }

    public static int lessThan(int[] nums, int k) {
        int count = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            if (nums[right] >= k)
                left = right + 1;
            count += right - left + 1;
        }
        return count;
    }
}
