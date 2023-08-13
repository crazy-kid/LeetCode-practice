package JAVA.Mid;

public class mid_1049 {

    public static void main(String[] args) {
        int[] stones = { 31, 26, 33, 21, 40 };

        int sum = 0, n = stones.length;
        for (int stone : stones)
            sum += stone;
        int[][] dp = new int[n][sum + 1];
        for (int i = 2 * stones[0]; i <= sum; i++)
            dp[0][i] = 2 * stones[0];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - 2 * stones[i] >= 0)
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 2 * stones[i]] + 2 * stones[i]);
            }
        }
        System.out.println(sum - dp[n - 1][sum]);
    }
}
