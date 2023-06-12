package JAVA.Mid;

public class mid_1230 {

    public static void main(String[] args) {
        double[] prob = { 0.4 };
        int target = 1;

        int n = prob.length;
        double[][] dp = new double[Math.max(2, target + 1)][n];

        dp[0][0] = 1 - prob[0];
        dp[1][0] = prob[0];

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= i + 1 & t <= target; t++) {
                dp[t][i] += dp[t][i - 1] * (1 - prob[i]);
                if (t - 1 >= 0)
                    dp[t][i] += dp[t - 1][i - 1] * prob[i];
            }
        }

        System.out.println(dp[target][n - 1]);
    }
}
