package JAVA.Mid;

public class mid_96 {

    public static void main(String[] args) {
        int n = 10;

        if (n == 1)
            return;
        if (n == 2)
            return;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        System.out.println(dp[n]);
    }
}
