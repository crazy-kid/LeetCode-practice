package JAVA.Mid;

public class mid_276 {

    public static void main(String[] args) {
        int n = 1;
        int k = 1;

        int[][] dp = new int[n + 1][2];// dp[left][continue color]
        dp[1][0] = k;
        dp[1][1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) * (k - 1);
            dp[i][1] = dp[i - 1][0];
        }
        System.out.println(dp[n][0] + dp[n][1]);
    }
}
