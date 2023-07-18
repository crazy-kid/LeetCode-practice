package JAVA.Mid;

public class mid_695 {

    public static int[][] grid = {
            { 1, 1, 0, 0, 0 },
            { 1, 1, 0, 0, 0 },
            { 0, 0, 0, 1, 1 },
            { 0, 0, 0, 1, 1 } };

    public static void main(String[] args) {
        int ans = 0;
        int m = grid.length, n = grid[0].length;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                ans = Math.max(ans, dfs(row, col));
            }
        }
        System.out.println(ans);
    }

    public static int dfs(int row, int col) {
        if (grid[row][col] == 0)
            return 0;
        int ret = 1;
        grid[row][col] = 0;
        if (row > 0)
            ret += dfs(row - 1, col);
        if (row < grid.length - 1)
            ret += dfs(row + 1, col);
        if (col > 0)
            ret += dfs(row, col - 1);
        if (col < grid[0].length - 1)
            ret += dfs(row, col + 1);
        return ret;
    }
}
