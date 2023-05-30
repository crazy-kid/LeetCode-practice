public class mid_53 {

    public static void main(String[] args) {
        int[] nums = { -2, -1 };

        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        dp[0] = Integer.MIN_VALUE;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i - 1], nums[i - 1]);
        }

        int ans = Integer.MIN_VALUE;
        for (int e : dp) {
            ans = Math.max(ans, e);
        }
        System.out.println(ans);
    }
}
