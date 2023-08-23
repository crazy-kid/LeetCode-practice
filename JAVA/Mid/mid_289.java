package JAVA.Mid;

class mid_289 {

    static int[][] bais = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

    public static void main(String[] args) {
        int[][] board = { { 1, 1 }, { 1, 0 } };
        int m = board.length, n = board[0].length;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++)
                board[row][col] = next(board, row, col);
        }
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++)
                board[row][col] = board[row][col] > 0 ? 1 : 0;
        }
    }

    public static int next(int[][] board, int r, int c) {
        int m = board.length, n = board[0].length;
        int count = 0;
        for (int[] b : bais) {
            if (r + b[0] >= 0 & r + b[0] < m & c + b[1] >= 0 & c + b[1] < n) {
                if (board[r + b[0]][c + b[1]] == 1 | board[r + b[0]][c + b[1]] == -1)
                    count++;
            }
        }
        if (board[r][c] == 1) {
            if (count < 2)
                return -1;
            if (count <= 3)
                return 1;
            return -1;
        } else if (count == 3)
            return 2;
        return -2;
    }
}