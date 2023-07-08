package JAVA.Mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class mid_207 {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 }, { 0, 1 } };

        int[] in = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<Integer>();
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
            in[prerequisite[0]]++;
        }
        for (int i = 0; i < numCourses; i++)
            if (in[i] == 0)
                queue.add(i);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                in[neighbor]--;
                if (in[neighbor] == 0)
                    queue.add(neighbor);
            }
        }
        for (int i : in)
            if (i != 0) {
                System.out.println(false);
            }
    }
}
