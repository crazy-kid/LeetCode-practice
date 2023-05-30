import java.util.Arrays;

public class mid_368 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        int n = nums.length;
        int[] pre = new int[n];
        Arrays.fill(pre, -1);
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[i] < dp[j] + 1) {
                        pre[i] = j;
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }
        for(int e : dp){
            System.out.println(e);
        }
    }
}
