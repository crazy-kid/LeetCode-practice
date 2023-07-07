package JAVA.Mid;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class mid_802 {

    public static void main(String[] args) {
        int[][] graph = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };

        int n = graph.length;
        HashSet<Integer>[] out = new HashSet[n];
        HashSet<Integer>[] in = new HashSet[n];
        for (int i = 0; i < n; i++) {
            out[i] = new HashSet<Integer>();
            in[i] = new HashSet<Integer>();
        }
        for (int i = 0; i < n; i++) {
            int[] edges = graph[i];
            for (int j : edges) {
                out[i].add(j);
                in[j].add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (out[i].size() == 0)
                queue.add(i);
        }
        while (!queue.isEmpty()) {
            int i = queue.poll();
            for (int j : in[i]) {
                out[j].remove(i);
                if (out[j].size() == 0)
                    queue.add(j);
            }
            in[i].clear();
        }
        for (int i = 0; i < n; i++) {
            if (out[i].size() == 0)
                System.out.print(i + " ");
        }
    }
}
