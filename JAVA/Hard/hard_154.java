package JAVA.Hard;

public class hard_154 {
    public static void main(String[] args) {
        int[] nums = { 10, 1, 10, 10, 10 };
        System.out.println(min(nums, 0, nums.length - 1));
    }

    public static int min(int[] nums, int l, int r) {
        if (r < l)
            return Integer.MAX_VALUE;
        if (r == l)
            return nums[r];
        int left = l, right = r;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[left]) {
                right = mid;
                continue;
            }
            if (nums[mid] > nums[right]) {
                left = mid + 1;
                continue;
            }
            if (nums[left] == nums[mid] & nums[mid] == nums[right]) {
                int a = min(nums, left, mid);
                int b = min(nums, mid + 1, right);
                return Math.min(a, b);
            }
            return nums[left];
        }
        return nums[left];
    }
}