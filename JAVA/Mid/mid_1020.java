package JAVA.Mid;

public class mid_1020 {

    public static int[][] grid = {
            { 0, 0, 0, 0 },
            { 1, 0, 1, 0 },
            { 0, 1, 1, 0 },
            { 0, 0, 0, 0 } };
    public static int m, n;

    public static void main(String[] args) {
        m = grid.length;
        n = grid[0].length;
        int sum = 0, yellow = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++)
                if (grid[row][col] == 1)
                    sum++;
        }
        for (int row = 0; row < m; row++) {
            yellow += dfs(row, 0);
            yellow += dfs(row, n - 1);
        }
        for (int col = 0; col < n; col++) {
            yellow += dfs(0, col);
            yellow += dfs(m - 1, col);
        }
        System.out.println(sum - yellow);
    }

    public static int dfs(int row, int col) {
        if (grid[row][col] == 0)
            return 0;
        int ret = 1;
        grid[row][col] = 0;
        if (row > 0)
            ret += dfs(row - 1, col);
        if (row < m - 1)
            ret += dfs(row + 1, col);
        if (col > 0)
            ret += dfs(row, col - 1);
        if (col < n - 1)
            ret += dfs(row, col + 1);
        return ret;
    }
}
