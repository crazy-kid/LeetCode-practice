public class mid_79 {

    public static int m;
    public static int n;
    public static boolean[][] matrix;
    public static char[][] board;

    public static void main(String[] args) {
        board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCCED";
        m = board.length;
        n = board[0].length;
        matrix = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == word.charAt(0)) {
                    matrix[row][col] = true;
                    if (backTrack(row, col, word, 1))
                        System.out.println(row + " " + col);
                    matrix[row][col] = false;
                }
            }
        }
    }

    public static boolean backTrack(int row, int col, String word, int first) {
        if (first == word.length())
            return true;
        if (row + 1 < m && !matrix[row + 1][col] && board[row + 1][col] == word.charAt(first)) {
            matrix[row + 1][col] = true;
            if (backTrack(row + 1, col, word, first + 1))
                return true;
            matrix[row + 1][col] = false;
        }
        if (row - 1 >= 0 && !matrix[row - 1][col] && board[row - 1][col] == word.charAt(first)) {
            matrix[row - 1][col] = true;
            if (backTrack(row - 1, col, word, first + 1))
                return true;
            matrix[row - 1][col] = false;
        }
        if (col + 1 < n && !matrix[row][col + 1] && board[row][col + 1] == word.charAt(first)) {
            matrix[row][col + 1] = true;
            if (backTrack(row, col + 1, word, first + 1))
                return true;
            matrix[row][col + 1] = false;
        }
        if (col - 1 >= 0 && !matrix[row][col - 1] && board[row][col - 1] == word.charAt(first)) {
            matrix[row][col - 1] = true;
            if (backTrack(row, col - 1, word, first + 1))
                return true;
            matrix[row][col - 1] = false;
        }
        return false;
    }
}
