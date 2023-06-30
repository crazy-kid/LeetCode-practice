package JAVA.Mid;

import java.util.PriorityQueue;

public class mid_1738 {

    public static void main(String[] args) {
        int[][] matrix = { { 5, 2 }, { 1, 6 } };
        int k = 3;

        int m = matrix.length, n = matrix[0].length;
        int[][] pre = new int[m + 1][n + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int row = 1; row < m + 1; row++) {
            for (int col = 1; col < n + 1; col++) {
                pre[row][col] = pre[row - 1][col] ^ pre[row][col - 1] ^ pre[row - 1][col - 1]
                        ^ matrix[row - 1][col - 1];
                if (pq.size() < k) {
                    pq.add(pre[row][col]);
                } else {
                    if (pq.peek() < pre[row][col]) {
                        pq.poll();
                        pq.add(pre[row][col]);
                    }
                }
            }
        }
        System.out.println(pq.poll());
    }
}
