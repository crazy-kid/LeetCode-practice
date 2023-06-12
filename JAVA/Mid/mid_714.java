package JAVA.Mid;

public class mid_714 {

    public static void main(String[] args) {
        int[] prices = { 2, 1, 4, 4, 2, 3, 2, 5, 1, 2 };
        int fee = 1;

        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        buy[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
        }
        int ans = 0;
        for (int p : sell)
            ans = Math.max(ans, p);
        System.out.println(ans);
    }
}
