package JAVA.Mid;

import java.util.ArrayList;
import java.util.List;

public class mid_797 {

    static List<List<Integer>> ans = new ArrayList<List<Integer>>();
    static int dst;
    static int[][] graph;

    public static void main(String[] args) {
        graph = new int[][] { { 4, 3, 1 }, { 3, 2, 4 }, { 3 }, { 4 }, {} };

        int n = graph.length;
        dst = n - 1;
        boolean[] isVisit = new boolean[n];
        isVisit[0] = true;
        List<Integer> path = new ArrayList<Integer>();
        path.add(0);
        dfs(isVisit, path);
        for (List<Integer> list : ans) {
            for (int i : list)
                System.out.print(i + " ");
            System.out.println();
        }

    }

    public static void dfs(boolean[] isVisit, List<Integer> path) {
        int[] neighborhood = graph[path.get(path.size() - 1)];
        for (int next : neighborhood) {
            if (next == dst) {
                path.add(next);
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.addAll(path);
                ans.add(tmp);
                path.remove(path.size() - 1);
                continue;
            }
            if (!isVisit[next]) {
                path.add(next);
                isVisit[next] = true;
                dfs(isVisit, path);
                isVisit[next] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
