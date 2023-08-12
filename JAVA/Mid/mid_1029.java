package JAVA.Mid;

import java.util.PriorityQueue;

public class mid_1029 {

    public static void main(String[] args) {
        int[][] costs = {
                { 515, 563 }, { 451, 713 }, { 537, 709 }, { 343, 819 }, { 855, 779 }, { 457, 60 },
                { 650, 359 }, { 631, 42 } };

        int ans = 0, n = costs.length / 2;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int[] cost : costs) {
            ans += cost[1];
            pq.add(-cost[1] + cost[0]);
        }
        for (int i = 0; i < n; i++)
            ans += pq.poll();

        System.out.println(ans);
    }
}
