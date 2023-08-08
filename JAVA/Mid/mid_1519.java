package JAVA.Mid;

import java.util.ArrayList;
import java.util.List;

public class mid_1519 {

    static int n = 4;
    static int[][] edges = { { 0, 3 }, { 0, 2 }, { 1, 2 } };
    static String labels = "aeed";
    static char[] list = labels.toCharArray();
    static int[] ans = new int[n];
    static List<Integer>[] graph = new ArrayList[n];
    static boolean[] visited = new boolean[n];

    public static void main(String[] args) {

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<Integer>();
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            graph[x].add(y);
            graph[y].add(x);
        }
        dfs(0);
        for (int i : ans)
            System.out.print(i + " ");
    }

    public static int[] dfs(int root) {
        visited[root] = true;
        int[] count = new int[26];
        for (int child : graph[root]) {
            if (visited[child])
                continue;
            int[] tmp = dfs(child);
            for (int i = 0; i < 26; i++)
                count[i] += tmp[i];
        }
        count[list[root] - 'a']++;
        ans[root] = count[list[root] - 'a'];
        return count;
    }
}
