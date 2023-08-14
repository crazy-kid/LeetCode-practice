package JAVA.Mid;

public class mid_416 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 5 };

        int target = 0;
        for (int i : nums)
            target += i;
        if (target % 2 != 0)
            return;
        target /= 2;
        boolean[][] dp = new boolean[nums.length][target + 1];
        if (nums[0] < target)
            dp[0][nums[0]] = true;
        dp[0][0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i] && dp[i - 1][j - nums[i]])
                    dp[i][j] = true;
            }
        }
        for (int i = 0; i < nums.length; i++)
            if (dp[i][target]) {
                System.out.println(true);
                return;
            }
    }
}
