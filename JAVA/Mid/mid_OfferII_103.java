package JAVA.Mid;

public class mid_OfferII_103 {

    public static void main(String[] args) {
        int[] coins = { 2 };
        int amount = 3;

        if (amount == 0)
            return;
        int[] dp = new int[amount + 1];
        for (int i : coins)
            if (i <= amount)
                dp[i] = 1;

        for (int i = 1; i <= amount; i++) {
            if (dp[i] == 0) {
                int min = Integer.MAX_VALUE;
                for (int c : coins) {
                    if (i - c >= 0 && dp[i - c] != -1) {
                        min = Math.min(min, dp[i - c] + 1);
                    }
                }
                if (min != Integer.MAX_VALUE) {
                    dp[i] = min;
                } else {
                    dp[i] = -1;
                }
            }
        }
        System.out.println(dp[amount]);
    }

}
