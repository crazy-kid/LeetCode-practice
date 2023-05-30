import java.util.Arrays;

public class mid_45 {

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };

        int[] dp = new int[nums.length];
        Arrays.fill(dp, nums.length);
        dp[0] = 0;
        for (int i = 0; i < dp.length - 1; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        System.out.println(dp[nums.length - 1]);
    }
}
