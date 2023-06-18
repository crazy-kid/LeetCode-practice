package JAVA.Mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class mid_210 {

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };

        // 建图
        int[] count = new int[numCourses];
        List<Integer>[] edges = new ArrayList[numCourses];
        for (int i = 0; i < edges.length; i++)
            edges[i] = new ArrayList<Integer>();
        for (int[] edge : prerequisites) {
            edges[edge[0]].add(edge[1]);
            count[edge[1]]++;
        }

        int[] ans = new int[numCourses];
        int index = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++)
            if (count[i] == 0)
                queue.add(i);
        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int end : edges[course]) {
                if (0 == --count[end])
                    queue.add(end);
            }
            count[course]--;
            ans[index] = course;
            index++;
        }

        boolean possible = true;
        for (int i : count)
            if (i != -1)
                possible = false;
        if (!possible)
            return;
        for (int i : ans)
            System.out.print(i + " ");
    }
}
