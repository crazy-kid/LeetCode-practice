package JAVA.Mid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class mid_310 {

    static List<Integer> ans = new ArrayList<Integer>();
    static int n;
    static HashSet<Integer>[] graph;

    public static void main(String[] args) {
        int[][] edges = { { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4 } };
        n = 6;

        graph = new HashSet[n];
        for (int i = 0; i < n; i++)
            graph[i] = new HashSet<Integer>();
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            graph[x].add(y);
            graph[y].add(x);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < n; i++)
            if (graph[i].size() == 1) {
                queue.add(i);
            }
        while (!queue.isEmpty()) {
            ans.clear();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int child = queue.poll();
                ans.add(child);
                for (Integer pa : graph[child]) {
                    graph[pa].remove(child);
                    if (graph[pa].size() == 1)
                        queue.add(pa);
                }
            }
        }
        for (int i : ans)
            System.out.print(i + " ");
    }
}
