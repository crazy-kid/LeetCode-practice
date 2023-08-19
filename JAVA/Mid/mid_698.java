package JAVA.Mid;

import java.util.Arrays;

public class mid_698 {

    static int[] nums = { 2, 2, 2, 2, 3, 4, 5 };
    static int k = 4, n, per;
    static boolean[] dp;

    public static void main(String[] args) {
        Arrays.sort(nums);
        n = nums.length;
        int sum = Arrays.stream(nums).sum();
        per = sum / k;
        if (sum % k != 0 || per < nums[n - 1])
            return;
        dp = new boolean[(1 << n)];
        Arrays.fill(dp, true);
        System.out.println(dfs(0, 0));
    }

    public static boolean dfs(int state, int curSum) {
        // System.out.println(Integer.toBinaryString(state) + " " + curSum);
        if (!dp[state])
            return false;
        // boolean set = true;
        if (state == (1 << n) - 1)
            return true;
        for (int i = 0; i < n; i++) {
            if ((state >> i & 1) == 0) {
                int next = state | 1 << i;
                int tmp = (curSum + nums[i]) % per;
                if (curSum + nums[i] <= per) {
                    if (dfs(next, tmp)) {
                        System.out.println(Integer.toBinaryString(next) + " " + tmp);
                        return true;
                    }
                } else
                    dp[next] = false;
            }
        }
        dp[state] = false;
        return false;
    }
}
