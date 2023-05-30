
public class mid_813 {

    public static void main(String[] args) {
        int[] nums = { 9, 1, 2, 3, 9 };
        int k = 3;

        int n = nums.length;
        int[] preSum = new int[n];
        preSum[0] = nums[0];// 前缀和
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }

        double[][] dp = new double[n][k];
        for (int i = 0; i < n; i++) {
            dp[i][0] = (double) preSum[i] / (i + 1);
        }

        for (int j = 1; j < k; j++) { // j = k-1
            for (int i = j; i < n; i++) {
                for (int l = j - 1; l <= i - 1; l++) {
                    dp[i][j] = Math.max(dp[i][j], dp[l][j - 1] + (double) (preSum[i] - preSum[l]) / (i - l));
                }
            }
        }

        System.out.println(dp[n - 1][k - 1]);

    }
}
