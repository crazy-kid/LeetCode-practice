package JAVA.Mid;

public class mid_837 {

    public static void main(String[] args) {
        int n = 21, k = 17, maxPts = 10;

        if (k - 1 + maxPts <= n)
            return;
        double[] dp = new double[k + maxPts];
        for (int i = n + 1; i <= k - 1 + maxPts; i++)
            dp[i] = 0;
        for (int i = k; i <= n; i++)
            dp[i] = 1;
        if (k > 0)
            dp[k - 1] = (double) Math.max(0, n - k + 1) / maxPts;
        for (int i = k - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + (dp[i + 1] - dp[i + 1 + maxPts]) / maxPts;
        }
        System.out.println(dp[0]);
    }
}
