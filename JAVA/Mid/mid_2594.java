package JAVA.Mid;

import java.util.Arrays;

public class mid_2594 {

    static int[] ranks = { 3, 3, 5, 1, 1, 3, 3, 7, 4 };
    static int cars = 1088;
    static int n;
    static int[] task;
    static long[][] memo;

    public static void main(String[] args) {

        n = ranks.length;
        task = new int[n];
        Arrays.sort(ranks);
        memo = new long[n + 1][cars + 1];
        for (long[] list : memo)
            Arrays.fill(list, -1);
        int min = cars / n;
        long ans = Integer.MAX_VALUE;
        for (int num = Math.max(1, min); num <= cars; num++) {
            task[0] = num;
            long tmp = Math.max(ranks[0] * num * num, dfs(1, cars - num));
            ans = Math.min(tmp, ans);
        }
        System.out.println(ans);
    }

    public static long dfs(int idx, int left) {
        if (memo[idx][left] >= 0)
            return memo[idx][left];
        if (left == 0) {
            memo[idx][left] = 0;
            return 0;
        }
        if (idx == n) {
            memo[idx][left] = Long.MAX_VALUE;
            return Long.MAX_VALUE;
        }
        // if (idx == 0) {
        // System.out.println("error");
        // return Integer.MAX_VALUE;
        // }
        long ret = Long.MAX_VALUE;
        for (int num = 1; num <= task[idx - 1] && num <= left; num++) {
            task[idx] = num;
            long tmp = Math.max(ranks[idx] * num * num, dfs(idx + 1, left - num));
            ret = Math.min(ret, tmp);
        }
        memo[idx][left] = ret;
        return ret;
    }
}
