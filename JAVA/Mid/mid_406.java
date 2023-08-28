package JAVA.Mid;

import java.util.Comparator;
import java.util.PriorityQueue;

public class mid_406 {

    public static void main(String[] args) {
        int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };

        int n = people.length;
        int[][] ans = new int[n][2];
        for (int i = 0; i < n; i++) {
            ans[i][0] = -1;
            ans[i][1] = -1;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        for (int[] person : people)
            pq.add(person);
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int cur = 0, step = p[1];
            while (step > 0) {
                if (ans[cur][0] == -1 | ans[cur][0] == p[0])
                    step--;
                cur++;
            }
            while (ans[cur][0] != -1)
                cur++;
            ans[cur][0] = p[0];
            ans[cur][1] = p[1];
        }

        for (int[] p : ans)
            System.out.println(p[0] + " " + p[1]);
    }
}
