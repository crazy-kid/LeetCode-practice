package JAVA.Mid;

public class mid_2140 {
    public static void main(String[] args) {
        int[][] questions = { { 12, 46 }, { 78, 19 }, { 63, 15 }, { 79, 62 }, { 13, 10 } };
        int n = questions.length;
        int[] dp = new int[n];
        dp[n - 1] = questions[n - 1][0];
        for (int i = n - 2; i >= 0; i--) {
            int fesibleIndex = i + questions[i][1] + 1;
            if (fesibleIndex <= n - 1) {
                dp[i] = Math.max(dp[i + 1], questions[i][0] + dp[fesibleIndex]);
            } else {
                dp[i] = Math.max(questions[i][0], dp[i + 1]);
            }
        }
        System.out.println(dp[0]);
    }

}
