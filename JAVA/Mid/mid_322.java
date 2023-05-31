import java.util.Arrays;

public class mid_322 {

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 11;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i : coins)
            dp[i] = 1;
        for (int i = 1; i < amount + 1; i++) {
            for (int c : coins) {
                if (i - c >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }
        if (dp[amount] != amount + 1)
            System.out.println(dp[amount]);
        else
            System.out.println(-1);
    }
}
