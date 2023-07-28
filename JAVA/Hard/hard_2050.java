package JAVA.Hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class hard_2050 {

    static int n = 5;
    static int[][] relations = { { 1, 5 }, { 2, 5 }, { 3, 5 }, { 3, 4 }, { 4, 5 } };
    static int[] time = { 1, 2, 3, 4, 5 };

    static ArrayList<Integer>[] graph = new ArrayList[n];
    static int[] count = new int[n];
    static int[] startTime = new int[n];

    public static void main(String[] args) {
        // build graph
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<Integer>();
        for (int[] edge : relations) {
            int pre = edge[0] - 1, next = edge[1] - 1;
            graph[pre].add(next);
            count[next]++;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < n; i++)
            if (count[i] == 0)
                queue.add(i);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph[cur]) {
                startTime[next] = Math.max(startTime[next], startTime[cur] + time[cur]);
                if (--count[next] == 0)
                    queue.add(next);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++)
            ans = Math.max(ans, startTime[i] + time[i]);
        System.out.println(ans);
    }
}