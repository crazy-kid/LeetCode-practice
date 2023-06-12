package JAVA.Mid;

public class mid_647 {

    public static void main(String[] args) {
        String s = "aaa";

        char[] clists = s.toCharArray();
        int n = clists.length;
        boolean[][] dp = new boolean[n][n];
        int count = n;
        for (int i = 0; i < n; i++)
            dp[i][i] = true;
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (clists[i] == clists[j]) {
                    if (dp[i + 1][j - 1] | j - 1 < i + 1) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
