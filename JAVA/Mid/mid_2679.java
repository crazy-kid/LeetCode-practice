package JAVA.Mid;

import java.util.Comparator;
import java.util.PriorityQueue;

public class mid_2679 {

    public static void main(String[] args) {
        int[][] nums = {
                { 7, 2, 1 },
                { 6, 4, 2 },
                { 6, 5, 3 },
                { 3, 2, 1 } };

        int m = nums.length, n = nums[0].length;
        int ans = 0;
        PriorityQueue<Integer>[] pq = new PriorityQueue[m];
        for (int i = 0; i < m; i++)
            pq[i] = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                pq[row].add(nums[row][col]);
            }
        }
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int row = 0; row < m; row++) {
                max = Math.max(max, pq[row].poll());
            }
            ans += max;
        }
        System.out.println(ans);
    }
}
