package JAVA.Hard;

public class hard_410 {

    public static void main(String[] args) {
        int[] nums = { 7, 2, 5, 10, 8 };
        int m = 2;

        int n = nums.length;
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        int[][] dp = new int[m][n];
        dp[0][0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
            dp[0][i] = preSum[i];
        }
        for (int j = 1; j < m; j++) {
            for (int i = j; i < n; i++) {
                dp[j][i] = Integer.MAX_VALUE;
                for (int k = i - 1; k >= j - 1; k--) {
                    if (preSum[i] - preSum[k] > dp[j][i])
                        break;
                    dp[j][i] = Math.max(dp[j - 1][k], preSum[i] - preSum[k]);
                }
            }
        }

        System.out.println(dp[m - 1][n - 1]);
    }
}
