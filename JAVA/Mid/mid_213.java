public class mid_213 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        int n = nums.length;

        if (n == 1)
            return;

        int dp1 = nums[0];
        int dp0 = 0;
        int tmp = dp1;
        for (int i = 1; i < n - 1; i++) {
            tmp = dp1;
            dp1 = nums[i] + dp0;
            dp0 = Math.max(tmp, dp0);
        }

        // 没有第一项
        int dp01 = nums[1];
        int dp00 = 0;
        tmp = dp01;
        for (int i = 2; i < n; i++) {
            tmp = dp01;
            dp01 = nums[i] + dp00;
            dp00 = Math.max(tmp, dp00);
        }

        int ans = Math.max(dp1, dp0);
        ans = Math.max(ans, dp01);
        ans = Math.max(ans, dp00);
        System.out.println(ans);
    }
}
