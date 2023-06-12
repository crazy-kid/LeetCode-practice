package JAVA.Mid;

import java.util.Arrays;

public class mid_413 {
    public static void main(String[] args) {
        int[] nums = { 1 };

        int n = nums.length;
        int[] dp = new int[n];
        int[] diff = new int[n];
        Arrays.fill(dp, 2);
        dp[0] = 1;
        diff[0] = 5000;

        for (int i = 1; i < n; i++) {
            diff[i] = nums[i] - nums[i - 1];
            if (diff[i] == diff[i - 1])
                dp[i] = dp[i - 1] + 1;
        }

        int ans = 0;
        for (int i : dp) {
            ans += Math.max(i - 2, 0);
        }
        System.out.println(ans);
    }
}