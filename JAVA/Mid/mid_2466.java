public class mid_2466 {

    public static void main(String[] args) {
        int zero = 10;
        int one = 1;
        int low = 200;
        int high = 200;

        long[] dp = new long[high + 1];
        dp[0] = 1;
        for (int i = 1; i <= high; i++) {
            if (i - zero >= 0)
                dp[i] += dp[i - zero];
            if (i - one >= 0)
                dp[i] += dp[i - one];
        }
        int ans = 0;
        for (int i = low; i <= high; i++) {
            ans += dp[i];
            ans = ans % 1000000007;
        }
        System.out.println(ans);
    }

}
