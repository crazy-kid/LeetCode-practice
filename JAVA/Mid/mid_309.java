package JAVA.Mid;

import java.util.Arrays;

public class mid_309 {

    public static void main(String[] args) {
        int[] prices = { 1, 2, 3, 0, 2 };

        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        Arrays.fill(buy, Integer.MIN_VALUE / 2);
        Arrays.fill(sell, Integer.MIN_VALUE / 2);
        buy[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            if (i - 2 >= 0) {
                buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            }
            buy[i] = Math.max(buy[i], buy[i - 1]);
            buy[i] = Math.max(buy[i], -prices[i]);

            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        int ans = 0;
        for (int p : sell)
            ans = Math.max(ans, p);
        System.out.println(ans);
    }
}
