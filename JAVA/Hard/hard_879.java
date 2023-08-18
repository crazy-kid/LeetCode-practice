package JAVA.Hard;

import java.util.Arrays;

public class hard_879 {

    static int n = 5, minProfit = 3;
    static int[] group = { 2, 2 };
    static int[] profit = { 2, 3 };
    static int[][][] dp = new int[profit.length + 1][n + 1][minProfit + 1];
    static final int MOD = (int) 1e9 + 7;

    public static void main(String[] args) {
        // for (int[][] l : dp)
        // for (int[] k : l)
        // k[0] = 1;
        dp[0][0][0] = 1;
        for (int len = 1; len <= profit.length; len++) {
            int people = group[len - 1], earn = profit[len - 1];
            for (int j = 0; j <= n; j++) {
                for (int pro = 0; pro <= minProfit; pro++) {
                    dp[len][j][pro] = dp[len - 1][j][pro];
                    if (j - people >= 0) {
                        dp[len][j][pro] += dp[len - 1][j - people][Math.max(0, pro - earn)];
                        dp[len][j][pro] %= MOD;
                    }
                }
            }
        }
        int sum = 0;
        for (int j = 1; j <= n; j++) {
            sum += dp[profit.length][j][minProfit];
            sum %= MOD;
        }
        System.out.println(sum);
    }

}
