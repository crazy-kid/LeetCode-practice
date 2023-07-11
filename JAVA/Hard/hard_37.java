package JAVA.Hard;

public class hard_37 {

    public static final int VALID = 511;

    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        trackBack(0, 0, board);

    }

    public static boolean trackBack(int r, int c, char[][] board) {
        if (c == 9) {
            c = 0;
            r++;
        }
        if (r == 9 & c == 0) {
            System.out.println("finded");
            return true;
        }
        if (board[r][c] == '.') {
            int valid = checkRC(r, c, board) & checkBlock(r, c, board);
            for (int i = 1; i <= 9; i++) {
                if ((valid & (1 << (i - 1))) > 0) {
                    board[r][c] = (char) (i + '0');
                    if (trackBack(r, c + 1, board))
                        return true;
                }
            }
            board[r][c] = '.';
        } else {
            if (trackBack(r, c + 1, board))
                return true;
        }
        return false;
    }

    public static int checkRC(int r, int c, char[][] board) {
        // 1表示可行 0表示不可行
        int ret = VALID;
        for (int row = 0; row < 9; row++)
            if (board[row][c] != '.')
                ret &= ~(1 << (board[row][c] - '1'));
        for (int col = 0; col < 9; col++)
            if (board[r][col] != '.')
                ret &= ~(1 << (board[r][col] - '1'));
        return ret;
    }

    public static int checkDiag(int r, int c, char[][] board) {
        // 1表示可行 0表示不可行
        int ret = VALID;
        if (r == c) {
            for (int i = 0; i < 9; i++)
                if (board[i][i] != '.')
                    ret &= ~(1 << (board[i][i] - '1'));
        }
        if (r + c == 8) {
            for (int i = 0; i < 9; i++)
                if (board[i][8 - i] != '.')
                    ret &= ~(1 << (board[i][8 - i] - '1'));
        }
        return ret;
    }

    public static int checkBlock(int r, int c, char[][] board) {
        // 1表示可行 0表示不可行
        int ret = VALID;
        for (int row = r / 3 * 3; row < (r / 3 * 3) + 3; row++) {
            for (int col = c / 3 * 3; col < (c / 3 * 3) + 3; col++) {
                if (board[row][col] != '.')
                    ret &= ~(1 << (board[row][col] - '1'));
            }
        }
        return ret;
    }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < 9; row++) {
            System.out.println();
            for (int col = 0; col < 9; col++)
                System.out.print(board[row][col] + " ");
        }
        System.out.println();
    }
}
