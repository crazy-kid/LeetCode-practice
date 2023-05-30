public class mid_279 {
    public static void main(String[] args) {
        int n = 12;

        int[] dp = new int[n + 1];

        int r = 1;
        while (r * r <= n) {
            dp[r * r] = 1;
            r++;
        }

        for (int i = 1; i <= n; i++) {
            if (dp[i] > 0)
                continue;
            int c = 1;
            dp[i] = Integer.MAX_VALUE;
            while (c * c < i) {
                dp[i] = Math.min(dp[i], 1 + dp[i - c * c]);
                c++;
            }
        }
        System.out.println(dp[n]);
    }
}
