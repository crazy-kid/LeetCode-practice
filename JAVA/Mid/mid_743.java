package JAVA.Mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class mid_743 {

    public static int main(String[] args) {
        int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
        int n = 4, k = 2;

        List<int[]>[] edges = new ArrayList[n];
        for (int i = 0; i < n; i++)
            edges[i] = new ArrayList<int[]>();
        for (int[] edge : times) {
            int x = edge[0] - 1, y = edge[1] - 1, time = edge[2];
            edges[x].add(new int[] { y, time });
        }

        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k - 1] = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(k - 1);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int[] edge : edges[v]) {
                if (dis[v] + edge[1] < dis[edge[0]]) {
                    dis[edge[0]] = dis[v] + edge[1];
                    queue.add(edge[0]);
                }
            }
        }

        int ans = 0;
        for (int i : dis)
            ans = Math.max(ans, i);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
