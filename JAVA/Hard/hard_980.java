package JAVA.Hard;

public class hard_980 {

    static int[][] grid = {
            { 1, 0, 0, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 2, -1 } };
    static int m = grid.length, n = grid[0].length;
    static boolean[][] visited = new boolean[m][n];
    static int ans = 0, distens = 0;

    public static void main(String[] args) {
        int[] start = new int[2];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] != -1)
                    distens++;
                if (grid[row][col] == 1) {
                    start[0] = row;
                    start[1] = col;
                }
            }
        }

        dfs(start[0], start[1], 0);
        System.out.println(ans);
    }

    public static void dfs(int row, int col, int pathLen) {
        if (row < 0 | col < 0 | row >= m | col >= n || grid[row][col] == -1 | visited[row][col])
            return;

        visited[row][col] = true;
        pathLen++;
        dfs(row - 1, col, pathLen);
        dfs(row + 1, col, pathLen);
        dfs(row, col - 1, pathLen);
        dfs(row, col + 1, pathLen);
        if (pathLen == distens & grid[row][col] == 2)
            ans++;
        visited[row][col] = false;
    }
}
