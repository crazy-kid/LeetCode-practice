package JAVA.Mid;

import java.util.Arrays;

public class mid_300 {

    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
        }
        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
