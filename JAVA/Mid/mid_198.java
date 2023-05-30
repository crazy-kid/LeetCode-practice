public class mid_198 {

    public static void main(String[] args) {
        int[] nums = { 2, 7, 9, 3, 1 };

        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp0 = new int[n];

        dp1[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp1[i] = nums[i] + dp0[i - 1];
            dp0[i] = Math.max(dp1[i - 1], dp0[i - 1]);
        }

        System.out.println(Math.max(dp1[n - 1], dp0[n - 1]));
    }
}
