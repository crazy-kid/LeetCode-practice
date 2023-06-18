package JAVA.Mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mid_787 {

    public static void main(String[] args) {
        int n = 4, src = 0, dst = 3, k = 1;
        int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int[] cur = new int[n];
        int[] next = new int[n];
        // 建立邻接表
        List<int[]>[] edges = new ArrayList[n];
        for (int i = 0; i < n; i++)
            edges[i] = new ArrayList<>();
        int sum = 0;
        for (int[] edge : flights) {
            edges[edge[1]].add(new int[] { edge[0], edge[2] });
            sum += edge[2];
        }
        // Bellman-Ford
        Arrays.fill(cur, sum);
        Arrays.fill(next, sum);
        int step;
        cur[src] = 0;
        for (step = 1; step <= k + 1; step++) {
            for (int end = 0; end < n; end++) {
                next[end] = cur[end];
                for (int[] edge : edges[end]) {
                    int start = edge[0];
                    next[end] = Math.min(next[end], cur[start] + edge[1]);
                }
            }
            int[] tmp = cur;
            cur = next;
            next = tmp;
        }
        if (cur[dst] == sum)
            System.out.println(-1);
        System.out.println(cur[dst]);
    }
}
