package JAVA.Mid;

public class mid_1102 {

    static int[][] grid = {
            { 3, 4, 6, 3, 4 },
            { 0, 2, 1, 1, 7 },
            { 8, 8, 3, 2, 7 },
            { 3, 2, 4, 9, 8 },
            { 4, 1, 2, 0, 0 },
            { 4, 6, 5, 4, 3 } };
    static boolean[][] visited;
    // static int[][] grid = {
    // { 2, 2, 1, 2, 2, 2 },
    // { 1, 2, 2, 2, 1, 2 } };
    // static int[][] grid = {
    // { 5, 4, 5 },
    // { 1, 2, 6 },
    // { 7, 4, 6 } };
    static int m, n;

    public static void main(String[] args) {
        m = grid.length;
        n = grid[0].length;
        int right = Integer.MIN_VALUE, left = Integer.MAX_VALUE;
        for (int[] row : grid) {
            for (int i : row) {
                right = Math.max(right, i);
                left = Math.min(left, i);
            }
        }
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            visited = new boolean[m][n];
            if (dfs(0, 0, mid))
                left = mid;
            else
                right = mid - 1;
        }
        System.out.println(left);
    }

    public static boolean dfs(int row, int col, int min) {
        int val = grid[row][col];
        if (visited[row][col] || val < min)
            return false;
        visited[row][col] = true;
        if (row == m - 1 & col == n - 1)
            return true;
        if (row > 0 && dfs(row - 1, col, min))
            return true;
        if (row < m - 1 && dfs(row + 1, col, min))
            return true;
        if (col > 0 && dfs(row, col - 1, min))
            return true;
        if (col < n - 1 && dfs(row, col + 1, min))
            return true;
        return false;
    }
}
