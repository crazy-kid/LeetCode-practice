package JAVA.Mid;

import java.util.Arrays;

public class mid_673 {

    public static void main(String[] args) {
        int[] nums = { 2, 2, 2, 2, 2 };

        int n = nums.length;
        int[] count = new int[n + 1];
        int[] dp = new int[n + 1];

        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        for (int i = 2; i < n + 1; i++) {
            for (int j = i - 1; j >= 1; j--) {
                if (nums[j - 1] < nums[i - 1]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }
        }
        int maxLength = 0;
        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                ans = count[i];
            } else if (maxLength == dp[i]) {
                ans += count[i];
            }
        }
        System.out.println(ans);
    }
}
