package JAVA.Mid;

import java.util.Arrays;

public class mid_16 {

    public static void main(String[] args) {
        int[] nums = { -1, 2, 1, -4 };
        int target = 1;

        Arrays.sort(nums);
        int n = nums.length;
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        for (int first = 0; first < n - 2; first++) {
            int second = first + 1;
            int third = n - 1;
            while (second < third) {
                if (Math.abs(nums[first] + nums[second] + nums[third] - target) < diff) {
                    ans = nums[first] + nums[second] + nums[third];
                    diff = Math.abs(nums[first] + nums[second] + nums[third] - target);
                }
                if (nums[first] + nums[second] + nums[third] - target >= 0)
                    third--;
                else {
                    second++;
                }
            }
        }
        System.out.println(ans);
    }
}
