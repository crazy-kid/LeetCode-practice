public class mid_516 {

    public static void main(String[] args) {
        String s = "bbbab";

        char[] clists = s.toCharArray();
        int n = clists.length;
        int[][] dp = new int[n][n];
        int max = 1;
        for (int i = 0; i < n; i++)
            dp[i][i] = 1;
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (clists[i] == clists[j])
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 2);
                dp[i][j] = Math.max(dp[i][j], dp[i + 1][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                max = Math.max(dp[i][j], max);
            }
        }
        System.out.println(max);
    }
}
