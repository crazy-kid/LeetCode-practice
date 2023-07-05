package JAVA.Easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class easy_506 {

    public static void main(String[] args) {
        int[] score = { 5, 4, 3, 2, 1 };

        int n = score.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        for (int i = 0; i < n; i++) {
            pq.add(new int[] { score[i], i });
        }
        String[] ans = new String[n];
        int[] tmp = pq.poll();
        ans[tmp[1]] = "Gold Medal";
        if (pq.isEmpty())
            return;
        tmp = pq.poll();
        ans[tmp[1]] = "Silver Medal";
        if (pq.isEmpty())
            return;
        tmp = pq.poll();
        ans[tmp[1]] = "Bronze Medal";
        for (int i = 4; !pq.isEmpty(); i++) {
            tmp = pq.poll();
            ans[tmp[1]] = Integer.toString(i);
        }
        for (String str : ans)
            System.out.print(str + " ");
    }
}
