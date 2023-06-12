package JAVA.Mid;

public class mid_931 {

    public static void main(String[] args) {
        int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0] = matrix[0];
        for (int row = 1; row < m; row++) {
            for (int col = 0; col < n; col++) {
                dp[row][col] = matrix[row][col];
                int bias = dp[row - 1][col];
                if (col > 0) {
                    bias = Math.min(bias, dp[row - 1][col - 1]);
                }
                if (col < n - 1) {
                    bias = Math.min(bias, dp[row - 1][col + 1]);
                }
                dp[row][col] += bias;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int e : dp[m - 1]) {
            ans = Math.min(ans, e);
        }
        System.out.println(ans);
    }
}
