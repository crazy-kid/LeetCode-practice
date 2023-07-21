package JAVA.Mid;

public class mid_1631 {
    static int[][] heights = {
            { 1, 2, 3 },
            { 3, 8, 4 },
            { 5, 3, 5 } };
    static int m, n;
    static boolean[][] visited;

    public static void main(String[] args) {
        m = heights.length;
        n = heights[0].length;
        int left = 0, right = (int) 1e6;
        while (left < right) {
            int mid = left + (right - left) / 2;
            visited = new boolean[m][n];
            if (dfs(0, 0, mid))
                right = mid;
            else
                left = mid + 1;
        }
        System.out.println(left);
    }

    public static boolean dfs(int row, int col, int diff) {
        visited[row][col] = true;
        if (row == m - 1 & col == n - 1)
            return true;
        if (row > 0 && visited[row - 1][col] == false && Math.abs(heights[row][col] - heights[row - 1][col]) <= diff)
            if (dfs(row - 1, col, diff))
                return true;
        if (row < m - 1 && visited[row + 1][col] == false
                && Math.abs(heights[row][col] - heights[row + 1][col]) <= diff)
            if (dfs(row + 1, col, diff))
                return true;
        if (col > 0 && visited[row][col - 1] == false && Math.abs(heights[row][col] - heights[row][col - 1]) <= diff)
            if (dfs(row, col - 1, diff))
                return true;
        if (col < n - 1 && visited[row][col + 1] == false
                && Math.abs(heights[row][col] - heights[row][col + 1]) <= diff)
            if (dfs(row, col + 1, diff))
                return true;
        return false;
    }
}
