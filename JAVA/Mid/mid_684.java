package JAVA.Mid;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class mid_684 {

    public static void main(String[] args) {
        int[][] edges = { { 1, 2 }, { 1, 3 }, { 2, 3 } };

        int n = edges.length;
        HashSet<Integer>[] graph = new HashSet[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<Integer>();
        }
        for (int[] edge : edges) {
            int x = edge[0] - 1, y = edge[1] - 1;
            graph[x].add(y);
            graph[y].add(x);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < n; i++)
            if (graph[i].size() == 1)
                queue.add(i);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = graph[x].iterator().next();
            graph[x].clear();
            graph[y].remove(x);
            if (graph[y].size() == 1)
                queue.add(y);
        }
        for (int i = n - 1; i >= 0; i--) {
            int x = edges[i][0] - 1, y = edges[i][1] - 1;
            if (graph[x].size() > 0 & graph[y].size() > 0) {
                System.out.println((x + 1) + " " + (y + 1));
                return;
            }
        }
    }
}
