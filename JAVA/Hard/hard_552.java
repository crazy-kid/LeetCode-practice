package JAVA.Hard;

public class hard_552 {

    public static void main(String[] args) {
        int n = 10101;
        final int MOD = (int) 1e9 + 7;

        long[][][] dp = new long[n + 1][3][2];// day late absent
        dp[1][0][0] = 1;
        dp[1][0][1] = 1;
        dp[1][1][0] = 1;
        for (int day = 2; day <= n; day++) {
            dp[day][0][0] = (dp[day - 1][0][0] + dp[day - 1][1][0] + dp[day - 1][2][0]) % MOD;
            dp[day][1][0] = dp[day - 1][0][0];
            dp[day][2][0] = dp[day - 1][1][0];

            dp[day][0][1] = (dp[day - 1][0][1] + dp[day - 1][1][1] + dp[day - 1][2][1]
                    + dp[day - 1][0][0] + dp[day - 1][1][0] + dp[day - 1][2][0]) % MOD;
            dp[day][1][1] = dp[day - 1][0][1];
            dp[day][2][1] = dp[day - 1][1][1];
        }
        long ans = (dp[n][0][0] + dp[n][1][0] + dp[n][2][0] + dp[n][0][1] + dp[n][1][1] + dp[n][2][1]) % MOD;
        System.out.println(ans);
    }
}
