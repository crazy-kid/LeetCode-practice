package JAVA.Mid;

import java.util.ArrayList;
import java.util.List;

public class mid_1034 {

    static int[][] grid = { { 2, 2, 2 }, { 2, 2, 2 }, { 2, 2, 2 } };
    static int row = 1, col = 1, color = 3;
    static List<int[]> list = new ArrayList<int[]>();
    static boolean[][] visited;
    static int m, n;

    public static void main(String[] args) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        int origin = grid[row][col];

        dfs(row, col, origin);
        for (int[] cor : list) {
            grid[cor[0]][cor[1]] = color;
        }
        System.out.println();
    }

    public static void dfs(int row, int col, int origin) {
        visited[row][col] = true;
        if (grid[row][col] != origin)
            return;
        if (row == 0 || row == m - 1 || col == 0 || col == n - 1 || grid[row - 1][col] != origin
                || grid[row + 1][col] != origin || grid[row][col - 1] != origin || grid[row][col + 1] != origin)
            list.add(new int[] { row, col });
        if (row > 0 && !visited[row - 1][col])
            dfs(row - 1, col, origin);
        if (row < m - 1 && !visited[row + 1][col])
            dfs(row + 1, col, origin);
        if (col > 0 && !visited[row][col - 1])
            dfs(row, col - 1, origin);
        if (col < n - 1 && !visited[row][col + 1])
            dfs(row, col + 1, origin);
    }
}
