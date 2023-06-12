package JAVA.Mid;

public class mid_122 {

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        int ans = 0;

        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        System.out.println(ans);
    }
}
