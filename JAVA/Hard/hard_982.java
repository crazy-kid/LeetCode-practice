package JAVA.Hard;

import java.util.Arrays;

public class hard_982 {
    static int[] nums = { 0, 0, 0 };
    static int[][] memo;

    public static void main(String[] args) {
        int len = 16;
        memo = new int[2][1 << len];
        Arrays.fill(memo[1], -1);
        for (int i = 0; i < memo[0].length; i++) {
            for (int num : nums)
                if ((num & i) == 0)
                    memo[0][i] += 1;
        }
        System.out.println(dfs(memo[0].length - 1, 2));
    }

    public static int dfs(int num, int step) {
        if (step <= 1 && memo[step][num] != -1)
            return memo[step][num];
        int ret = 0;
        for (int i : nums) {
            int next = dfs(num & i, step - 1);
            if (next > 0)
                ret += next;
        }
        if (step <= 1)
            memo[step][num] = ret;
        return ret;
    }
}
