import java.util.Arrays;

public class hard_188 {

    public static void main(String[] args) {
        int[] prices = { 6, 1, 3, 2, 4, 7 };
        int k = 3;

        int n = prices.length;
        int[][] buy = new int[k][n];
        int[][] sell = new int[k][n];

        for (int i = 0; i < k; i++)
            Arrays.fill(buy[i], Integer.MIN_VALUE);
        buy[0][0] = -prices[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (j - 1 >= 0) {
                    buy[j][i] = Math.max(buy[j][i - 1], sell[j - 1][i - 1] - prices[i]);
                    sell[j][i] = Math.max(sell[j][i - 1], buy[j][i - 1] + prices[i]);
                } else {
                    buy[0][i] = Math.max(buy[0][i - 1], -prices[i]);
                    sell[0][i] = Math.max(sell[0][i - 1], buy[0][i] + prices[i]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < k; i++) {
            for (int p : sell[i])
                ans = Math.max(p, ans);
        }
        System.out.println(ans);
    }
}
