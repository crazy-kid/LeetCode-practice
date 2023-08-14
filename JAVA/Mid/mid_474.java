package JAVA.Mid;

public class mid_474 {

    public static void main(String[] args) {
        String[] strs = { "10", "0001", "111001", "1", "0" };
        int m = 5, n = 3;
        int[][] nums = new int[strs.length][2];
        initNums(nums, strs);
        int[][][] dp = new int[nums.length][m + 1][n + 1];
        /* init dp */
        for (int zeros = nums[0][0]; zeros <= m; zeros++) {
            for (int ones = nums[0][1]; ones <= n; ones++)
                dp[0][zeros][ones] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int zeros = 0; zeros <= m; zeros++) {
                for (int ones = 0; ones <= n; ones++) {
                    dp[i][zeros][ones] = dp[i - 1][zeros][ones];
                    if (zeros - nums[i][0] >= 0 && ones - nums[i][1] >= 0)
                        dp[i][zeros][ones] = Math.max(dp[i][zeros][ones],
                                dp[i - 1][zeros - nums[i][0]][ones - nums[i][1]] + 1);
                }
            }
        }
        System.out.println(dp[nums.length - 1][m][n]);
    }

    public static void initNums(int[][] nums, String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            for (char c : strs[i].toCharArray()) {
                if (c == '0')
                    nums[i][0]++;
                else
                    nums[i][1]++;
            }
        }
    }
}
