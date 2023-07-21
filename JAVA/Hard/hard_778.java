package JAVA.Hard;

public class hard_778 {

    static int[][] grid = {
            { 0, 1, 2, 3, 4 },
            { 24, 23, 22, 21, 5 },
            { 12, 13, 14, 15, 16 },
            { 11, 17, 18, 19, 20 },
            { 10, 9, 8, 7, 6 } };
    static int n;
    static boolean[][] visited;

    public static void main(String[] args) {
        n = grid.length;
        int left = grid[0][0], right = 0;
        for (int[] row : grid)
            for (int num : row)
                right = Math.max(right, num);
        while (left < right) {
            int mid = left + (right - left) / 2;
            visited = new boolean[n][n];
            if (dfs(0, 0, mid))
                right = mid;
            else
                left = mid + 1;
        }
        System.out.println(left);
    }

    public static boolean dfs(int row, int col, int max) {
        visited[row][col] = true;
        if (row == n - 1 & col == n - 1)
            return true;
        if (row > 0 && visited[row - 1][col] == false && grid[row - 1][col] <= max)
            if (dfs(row - 1, col, max))
                return true;
        if (row < n - 1 && visited[row + 1][col] == false && grid[row + 1][col] <= max)
            if (dfs(row + 1, col, max))
                return true;
        if (col > 0 && visited[row][col - 1] == false && grid[row][col - 1] <= max)
            if (dfs(row, col - 1, max))
                return true;
        if (col < n - 1 && visited[row][col + 1] == false && grid[row][col + 1] <= max)
            if (dfs(row, col + 1, max))
                return true;
        return false;
    }
}
