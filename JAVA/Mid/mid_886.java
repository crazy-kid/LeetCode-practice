package JAVA.Mid;

import java.util.ArrayList;
import java.util.List;

public class mid_886 {

    public static void main(String[] args) {
        int n = 4;
        int[][] dislikes = { { 1, 2 }, { 1, 3 }, { 2, 4 } };

        int[] colors = new int[n];
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for (int[] edge : dislikes) {
            graph[edge[0] - 1].add(edge[1] - 1);
            graph[edge[1] - 1].add(edge[0] - 1);
        }
        for (int i = 0; i < n; i++)
            if (colors[i] == 0) {
                colors[i] = 1;
                if (!dfs(graph, colors, i))
                    return;
            }
        System.out.println(true);
    }

    public static boolean dfs(List<Integer>[] graph, int[] colors, int node) {
        for (int neighbor : graph[node]) {
            if (colors[neighbor] == colors[node])
                return false;
            else if (colors[neighbor] == 0) {
                colors[neighbor] = -colors[node];
                if (!dfs(graph, colors, neighbor))
                    return false;
            }
        }
        return true;
    }
}
