package JAVA.Mid;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class mid_909 {
    static int[][] board = {
            { -1, -1, -1, -1, 48, 5, -1 },
            { 12, 29, 13, 9, -1, 2, 32 },
            { -1, -1, 21, 7, -1, 12, 49 },
            { 42, 37, 21, 40, -1, 22, 12 },
            { 42, -1, 2, -1, -1, -1, 6 },
            { 39, -1, 35, -1, -1, 39, -1 },
            { -1, 36, -1, -1, -1, -1, 5 } };
    static int n;

    public static void main(String[] args) {
        n = board.length;
        int[] dp = new int[n * n + 1];
        Arrays.fill(dp, n * n);
        dp[1] = 0;
        int[] grid = new int[n * n + 1];
        for (int i = 1; i < grid.length; i++) {
            int[] dst = Index2RC(i);
            grid[i] = board[dst[0]][dst[1]];
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 1; i <= 6 && cur + i <= n * n; i++) {
                if (grid[cur + i] == -1) {
                    if (dp[cur + i] > dp[cur] + 1) {
                        dp[cur + i] = dp[cur] + 1;
                        queue.add(cur + i);
                    }
                } else {
                    if (dp[grid[cur + i]] > dp[cur] + 1) {
                        dp[grid[cur + i]] = dp[cur] + 1;
                        queue.add(grid[cur + i]);
                    }
                }
            }
        }
        System.out.println(dp[n * n]);
    }

    public static int getIndex(int row, int col) {
        int ret = (n - 1 - row) * n;
        if (((n - 1 - row) & 1) == 0)
            ret += col + 1;
        else
            ret += n - col;
        return ret;
    }

    public static int[] Index2RC(int i) {
        int[] ret = new int[2];
        ret[0] = n - (i + n - 1) / n;
        if ((n - 1 - ret[0]) % 2 == 0)
            ret[1] = i - 1 - n * (n - 1 - ret[0]);
        else
            ret[1] = (n - 1 - ret[0]) * n + n - i;
        return ret;
    }
}
