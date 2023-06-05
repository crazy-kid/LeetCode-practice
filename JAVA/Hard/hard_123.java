package JAVA.Hard;

import java.util.Arrays;

public class hard_123 {

    public static void main(String[] args) {
        int[] prices = { 6, 1, 3, 2, 4, 7 };

        int n = prices.length;
        int[] buy1 = new int[n];
        int[] sell1 = new int[n];
        int[] buy2 = new int[n];
        int[] sell2 = new int[n];

        buy1[0] = -prices[0];
        Arrays.fill(buy2, Integer.MIN_VALUE);
        for (int i = 1; i < n; i++) {
            buy1[i] = Math.max(-prices[i], buy1[i - 1]);
            sell1[i] = Math.max(sell1[i - 1], prices[i] + buy1[i - 1]);
            buy2[i] = Math.max(buy2[i - 1], sell1[i - 1] - prices[i]);
            sell2[i] = Math.max(sell2[i - 1], buy2[i - 1] + prices[i]);
        }
        int ans = 0;
        for (int p : sell2) {
            ans = Math.max(p, ans);
        }
        for (int p : sell1) {
            ans = Math.max(p, ans);
        }
        System.out.println(ans);
    }
}
