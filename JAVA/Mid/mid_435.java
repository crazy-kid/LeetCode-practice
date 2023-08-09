package JAVA.Mid;

import java.util.Comparator;
import java.util.PriorityQueue;

public class mid_435 {

    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                return i1[0] - i2[0];
            }
        });
        for (int[] interval : intervals)
            pq.add(interval);
        int[] curInterval = pq.poll();
        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            if (next[0] >= curInterval[1])
                curInterval = next;
            else {
                if (next[1] <= curInterval[1])
                    curInterval = next;
                ans++;
            }
        }
        System.out.println(ans);
    }
}
