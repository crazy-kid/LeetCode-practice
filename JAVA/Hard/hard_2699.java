package JAVA.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class hard_2699 {

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = { { 1, 0, 4 }, { 1, 2, 3 }, { 2, 3, 5 }, { 0, 3, -1 } };
        int source = 0;
        int destination = 2;
        int target = 6;

        List<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<int[]>());
        for (int eid = 0; eid < edges.length; eid++) {
            int[] edge = edges[eid];
            g[edge[0]].add(new int[] { edge[1], eid });
            g[edge[1]].add(new int[] { edge[0], eid });
        }

        int[][] dis = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i != source)
                dis[i][0] = dis[i][1] = Integer.MAX_VALUE;
        }

        dijkstra(g, edges, destination, dis, 0, 0);
        int delta = target - dis[destination][0];
        if (delta < 0)
            return;
        dijkstra(g, edges, destination, dis, delta, 1);
        if (dis[destination][1] < target)
            return;
        for (int[] edge : edges) {
            if (edge[2] == -1)
                edge[2] = 1;
        }
        return;
    }

    public static void dijkstra(List<int[]>[] g, int[][] edges, int destination, int[][] dis, int delta,
            int mode) {
        int n = g.length;
        boolean[] vis = new boolean[n];
        while (true) {
            int x = -1;
            for (int i = 0; i < n; i++)
                if (!vis[i] && (x < 0 || dis[i][mode] < dis[x][mode]))
                    x = i;
            if (x == destination)
                return;
            vis[x] = true;
            for (int[] e : g[x]) {
                int y = e[0], eid = e[1];
                int wt = edges[eid][2];
                if (wt == -1)
                    wt = 1;
                if (mode == 1 && edges[eid][2] == -1) {
                    int w = delta - dis[x][1] + dis[y][0];
                    if (w > wt)
                        edges[eid][2] = wt = w;
                }
                dis[y][mode] = Math.min(dis[y][mode], dis[x][mode] + wt);
            }
        }
    }
}
