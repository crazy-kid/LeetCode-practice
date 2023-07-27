package JAVA.Mid;

import java.util.LinkedList;
import java.util.Queue;

public class mid_1162 {
    static int[][] grid = { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
    static int m, n;

    public static void main(String[] args) {
        m = grid.length;
        n = grid[0].length;

        boolean one = false, zero = false;
        for (int row = 0; row < m; row++)
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1)
                    one = true;
                if (grid[row][col] == 0)
                    zero = true;
            }
        if (!(zero & one))
            return;

        Queue<int[]> queue = new LinkedList<int[]>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1)
                    queue.add(new int[] { row, col });
            }
        }
        int step = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pre = queue.poll();
                int r = pre[0], c = pre[1];
                if (r > 0 && grid[r - 1][c] == 0) {
                    grid[r - 1][c] = 1;
                    queue.add(new int[] { r - 1, c });
                }
                if (r < m - 1 && grid[r + 1][c] == 0) {
                    grid[r + 1][c] = 1;
                    queue.add(new int[] { r + 1, c });
                }
                if (c > 0 && grid[r][c - 1] == 0) {
                    grid[r][c - 1] = 1;
                    queue.add(new int[] { r, c - 1 });
                }
                if (c < n - 1 && grid[r][c + 1] == 0) {
                    grid[r][c + 1] = 1;
                    queue.add(new int[] { r, c + 1 });
                }
            }
            step++;
        }
        System.out.println(step);
    }
}
