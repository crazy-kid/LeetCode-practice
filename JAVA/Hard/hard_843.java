package JAVA.Hard;

import java.util.HashMap;

public class hard_843 {

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 }, { 0, 5 }, { 0, 6 } };

        HashMap<Integer, int[]>[] graph = new HashMap[n];
        for (int i = 0; i < n; i++)
            graph[i] = new HashMap<Integer, int[]>();
        for (int[] edge : edges) {
            graph[edge[0]].put(edge[1], new int[] { 0, 0 });
            graph[edge[1]].put(edge[0], new int[] { 0, 0 });
        }
        int[] ans = new int[n];
        for (int[] edge : edges) {
            dfs(graph, edge[0], edge[1]);
            dfs(graph, edge[1], edge[0]);
        }
        for (int i = 0; i < n; i++) {
            for (int child : graph[i].keySet()) {
                ans[i] += graph[i].get(child)[0];
            }
        }
        for (int i : ans)
            System.out.println(i);
    }

    public static void dfs(HashMap<Integer, int[]>[] graph, int root, int child) {
        System.out.println("dfs" + root + " " + child);
        if (graph[root].get(child)[0] > 0)
            return;
        if (graph[child].size() == 1) {
            graph[root].put(child, new int[] { 1, 1 });
            return;
        }
        int[] ret = new int[2];
        for (int grandSon : graph[child].keySet()) {
            if (grandSon == root)
                continue;
            dfs(graph, child, grandSon);
            ret[0] += graph[child].get(grandSon)[0];
            ret[1] += graph[child].get(grandSon)[1];
        }
        ret[1]++;
        ret[0] += ret[1];
        graph[root].put(child, new int[] { ret[0], ret[1] });
    }

}
