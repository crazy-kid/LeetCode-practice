package JAVA.Hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class hard_403 {

    static int[] stones = { 0, 1, 3, 5, 6, 8, 12, 17 };
    static int n = stones.length;
    static boolean[][] dp = new boolean[n][n];

    public static void main(String[] args) {
        Queue<int[]> queue = new LinkedList<int[]>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++)
            map.put(stones[i], i);
        Arrays.fill(dp[0], true);
        if (stones[1] != 1)
            return;
        queue.add(new int[] { 0, 1 });
        while (!queue.isEmpty()) {
            int[] pre = queue.poll();
            int len = stones[pre[1]] - stones[pre[0]];
            for (int bias = -1; bias <= 1; bias++) {
                int end = stones[pre[1]] + len + bias;
                if (map.containsKey(end) && !dp[pre[1]][map.get(end)]) {
                    if (map.get(end) == n - 1) {
                        System.out.println(true);
                        return;
                    }
                    dp[pre[1]][map.get(end)] = true;
                    queue.add(new int[] { pre[1], map.get(end) });
                }
            }
        }
        System.out.println(false);
    }
}
