package JAVA.Mid;

public class mid_130 {
    public static char[][] board = {
            { 'X', 'X', 'X', 'X' },
            { 'X', 'O', 'O', 'X' },
            { 'X', 'X', 'O', 'X' },
            { 'X', 'O', 'X', 'X' } };
    public static int m, n;

    public static void main(String[] args) {
        m = board.length;
        n = board[0].length;
        boolean[][] isO = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            dfs(row, 0, isO);
            dfs(row, n - 1, isO);
        }
        for (int col = 0; col < n; col++) {
            dfs(0, col, isO);
            dfs(m - 1, col, isO);
        }
        for (int row = 0; row < m; row++)
            for (int col = 0; col < n; col++) {
                if (!isO[row][col])
                    board[row][col] = 'X';
            }
    }

    public static void dfs(int row, int col, boolean[][] isO) {
        if (board[row][col] == 'O') {
            if (isO[row][col])
                return;
            isO[row][col] = true;
            if (row > 0)
                dfs(row - 1, col, isO);
            if (row < m - 1)
                dfs(row + 1, col, isO);
            if (col > 0)
                dfs(row, col - 1, isO);
            if (col < n - 1)
                dfs(row, col + 1, isO);
        } else
            return;
    }
}
