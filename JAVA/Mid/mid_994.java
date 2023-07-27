package JAVA.Mid;

import java.util.LinkedList;
import java.util.Queue;

public class mid_994 {

    static int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
    static int m, n;

    public static void main(String[] args) {
        m = grid.length;
        n = grid[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 2)
                    queue.add(new int[] { row, col });
            }
        }
        int time = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pre = queue.poll();
                int r = pre[0], c = pre[1];
                if (r > 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    queue.add(new int[] { r - 1, c });
                }
                if (r < m - 1 && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    queue.add(new int[] { r + 1, c });
                }
                if (c > 0 && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    queue.add(new int[] { r, c - 1 });
                }
                if (c < n - 1 && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    queue.add(new int[] { r, c + 1 });
                }
            }
            time++;
        }
        for (int row = 0; row < m; row++)
            for (int col = 0; col < n; col++)
                if (grid[row][col] == 1) {
                    System.out.println(-1);
                    return;
                }
        System.out.println(time);
    }

}
