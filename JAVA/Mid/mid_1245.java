package JAVA.Mid;

import java.util.ArrayList;
import java.util.List;

public class mid_1245 {

    static List<Integer>[] graph;
    static int n, ans = 0;

    public static void main(String[] args) {
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 4 }, { 4, 5 } };

        int n = edges.length + 1;
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<Integer>();
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            graph[x].add(y);
            graph[y].add(x);
        }
        dfs(0, -1);
        System.out.println(ans);
    }

    public static int dfs(int node, int pa) {
        int max1 = 0, max2 = 0;
        for (int child : graph[node]) {
            if (child != pa) {
                int val = dfs(child, node) + 1;
                if (val >= max1) {
                    max2 = max1;
                    max1 = val;
                } else if (val > max2)
                    max2 = val;
            }
        }
        ans = Math.max(max1 + max2, ans);
        return max1;
    }
}
