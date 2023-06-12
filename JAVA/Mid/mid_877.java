package JAVA.Mid;

public class mid_877 {
    public static void main(String[] args) {
        int[] piles = { 5, 3, 4, 5 };
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        System.out.println(dp[0][n - 1]);
    }

}
