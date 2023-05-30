public class mid_2327 {

    public static void main(String[] args) {
        int n = 4;
        int delay = 1;
        int forget = 3;

        int[] dp = new int[n + 1];
        for (int i = 1; i <= delay; i++)
            dp[i] = 1;
        for (int i = delay + 1; i <= n; i++) {
            for (int j = i - delay; j >= i - forget + 1 & j >= 1; j--) {
                dp[i] += dp[j];
                dp[i] = dp[i] % 1000000007;
            }
            if (i < forget + 1)
                dp[i]++;
            dp[i] = dp[i] % 1000000007;
        }
        System.out.println(dp[n]);
    }
}
