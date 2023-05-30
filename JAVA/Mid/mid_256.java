import java.util.Arrays;

public class mid_256 {

    public static void main(String[] args) {
        int[][] cost = { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } };

        int n = cost.length;
        int k = cost[0].length;

        int[][] dp = new int[n][k];
        for (int[] l : dp)
            Arrays.fill(l, Integer.MAX_VALUE);
        for (int i = 0; i < k; i++) {
            dp[0][i] = cost[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int color = 0; color < k; color++) {
                for (int other = 0; other < k; other++) {
                    if (color != other) {
                        dp[i][color] = Math.min(dp[i][color], dp[i - 1][other] + cost[i][color]);
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i : dp[n - 1]) {
            min = Math.min(min, i);
        }
        System.out.println(min);
    }
}
