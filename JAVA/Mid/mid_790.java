package JAVA.Mid;

public class mid_790 {

    public static void main(String[] args) {// 这题答案数据很大 即使有MOD的情况下也要用Long
        int n = 11;

        int[] dpUp = new int[n + 1];// 只有上面是实的
        int[] dpDown = new int[n + 1];// 只有下面是实的
        int[] dp = new int[n + 1];// 都是实的
        dp[0] = 1;

        for (int i = 1; i < n + 1; i++) {
            if (i - 2 >= 0) {
                dp[i] += dp[i - 2];
                dpUp[i] += dp[i - 2];
                dpDown[i] += dp[i - 2];
            }
            dpUp[i] += dpDown[i - 1];
            dpDown[i] += dpUp[i - 1];
            dp[i] += dp[i - 1];
            dp[i] += dpDown[i - 1];
            dp[i] += dpUp[i - 1];
        }
        System.out.println(dp[n]);
    }
}
