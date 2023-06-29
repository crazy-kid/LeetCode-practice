package JAVA.Mid;

import java.util.Arrays;

public class mid_259 {

    public static void main(String[] args) {
        int[] nums = { -2, 0, 1, 3 };
        int target = 2;

        int n = nums.length;
        if (n < 3)
            return;
        int ans = 0;
        Arrays.sort(nums);
        for (int first = 0; first < n - 2; first++) {
            int second = first + 1, third = n - 1;
            while (second < third) {
                while (second < third && nums[second] + nums[third] >= target - nums[first]) {
                    third--;
                }
                ans += third - second;
                second++;
            }
        }
        System.out.println(ans);
    }
}
