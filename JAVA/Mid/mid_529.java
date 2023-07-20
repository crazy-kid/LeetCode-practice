package JAVA.Mid;

public class mid_529 {
    static char[][] board = {
            { 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
            { 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'M' },
            { 'E', 'E', 'M', 'E', 'E', 'E', 'E', 'E' },
            { 'M', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
            { 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
            { 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
            { 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
            { 'E', 'E', 'M', 'M', 'E', 'E', 'E', 'E' } };
    static int[] click = { 0, 0 };
    static int m, n;
    static int[][] neighbors = { { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };

    public static void main(String[] args) {
        m = board.length;
        n = board[0].length;

        dfs(click[0], click[1]);
        printBoard();
    }

    public static void dfs(int row, int col) {
        if (row == 2 & col == 0) {
            System.out.println();
        }
        if (row < 0 | row >= m | col < 0 | col >= n)
            return;
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return;
        }
        if (board[row][col] == 'E') {
            int ret = 0;
            for (int[] neighbor : neighbors) {
                if (row + neighbor[0] >= 0 & row + neighbor[0] < m & col + neighbor[1] >= 0 & col + neighbor[1] < n)
                    if (board[row + neighbor[0]][col + neighbor[1]] == 'X'
                            | board[row + neighbor[0]][col + neighbor[1]] == 'M')
                        ret++;
            }
            if (ret > 0)
                board[row][col] = (char) (ret + '0');
            else {
                board[row][col] = 'B';
                for (int[] neighbor : neighbors)
                    dfs(row + neighbor[0], col + neighbor[1]);
            }
        }
    }

    public static void printBoard() {
        for (char[] row : board) {
            for (char c : row)
                System.out.print(c + " ");
            System.out.println();
        }
    }
}
