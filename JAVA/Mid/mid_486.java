package JAVA.Mid;

public class mid_486 {

    public static void main(String[] args) {
        int[] nums = { 0, 0, 7, 6, 5, 6, 1 };

        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            dp[i][i] = nums[i];
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        System.out.println(dp[0][n - 1]);
    }
}
