package JAVA.Mid;

import java.util.LinkedList;
import java.util.Queue;

public class mid_934 {
    static int[][] grid = {
            { 0, 1, 0, 0, 0 },
            { 0, 1, 0, 1, 1 },
            { 0, 0, 0, 0, 1 },
            { 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0 } };

    static int m = grid.length, n = grid[0].length;
    static boolean[][] visited = new boolean[m][n];
    static Queue<int[]> queue = new LinkedList<int[]>();

    public static void main(String[] args) {
        int ans = 0;
        boolean finded = false;
        for (int row = 0; row < m; row++) {
            if (finded)
                break;
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    dfs(row, col);
                    finded = true;
                    break;
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            for (int i = 0; i < size; i++) {
                int[] tmp = queue.poll();
                int row = tmp[0], col = tmp[1];
                if (row > 0 && !visited[row - 1][col]) {
                    if (grid[row - 1][col] == 1) {
                        System.out.println(ans);
                        return;
                    } else {
                        queue.add(new int[] { row - 1, col });
                        visited[row - 1][col] = true;
                    }
                }
                if (row + 1 < m && !visited[row + 1][col]) {
                    if (grid[row + 1][col] == 1) {
                        System.out.println(ans);
                        return;
                    } else {
                        queue.add(new int[] { row + 1, col });
                        visited[row + 1][col] = true;
                    }
                }
                if (col > 0 && !visited[row][col - 1]) {
                    if (grid[row][col - 1] == 1) {
                        System.out.println(ans);
                        return;
                    } else {
                        queue.add(new int[] { row, col - 1 });
                        visited[row][col - 1] = true;
                    }
                }
                if (col + 1 < n && !visited[row][col + 1]) {
                    if (grid[row][col + 1] == 1) {
                        System.out.println(ans);
                        return;
                    } else {
                        queue.add(new int[] { row, col + 1 });
                        visited[row][col + 1] = true;
                    }
                }
            }
        }
    }

    public static void dfs(int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || grid[row][col] == 0)
            return;
        visited[row][col] = true;
        queue.add(new int[] { row, col });
        dfs(row - 1, col);
        dfs(row + 1, col);
        dfs(row, col - 1);
        dfs(row, col + 1);
    }
}