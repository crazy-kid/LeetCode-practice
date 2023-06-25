package JAVA.Hard;

import java.util.Arrays;

public class hard_719 {

    public static void main(String[] args) {
        int[] nums = { 1, 6, 1 };
        int k = 3;

        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (MostK(nums, mid) < k)
                left = mid + 1;
            else
                right = mid;
        }
        System.out.println(left);
    }

    public static int MostK(int[] nums, int k) {
        int ret = 0, n = nums.length, diff = 0;
        int left = 0, right = 0;
        while (++right < n) {
            diff += nums[right] - nums[right - 1];
            while (diff > k) {
                diff -= nums[left + 1] - nums[left];
                left++;
            }
            ret += right - left;
        }
        return ret;
    }
}
