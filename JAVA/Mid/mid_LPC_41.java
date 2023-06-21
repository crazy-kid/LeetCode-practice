package JAVA.Mid;

import java.util.ArrayList;
import java.util.List;

public class mid_LPC_41 {
    public static char[][] board;
    public static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 },
            { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };
    public static int n, m;

    public static void main(String[] args) {
        String[] chessboard = {
                ".O.....",
                ".O.....",
                "XOO.OOX",
                ".OO.OO.",
                ".XO.OX.",
                "..X.X.." };

        n = chessboard.length;
        m = chessboard[0].length();
        board = new char[n][m];
        for (int row = 0; row < n; row++)
            board[row] = chessboard[row].toCharArray();

        int ans = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (board[row][col] == '.') {
                    board[row][col] = 'X';
                    List<int[]> tmp = check(new int[] { row, col });
                    if (tmp.size() > 0)
                        System.out.print("\nrow=" + row + " col=" + col);
                    for (int[] p : tmp) {
                        System.out.print("(" + p[0] + "," + p[1] + ") ");
                        board[p[0]][p[1]] = 'O';
                    }
                    board[row][col] = '.';
                    ans = Math.max(ans, tmp.size());
                }
            }
        }
        System.out.println(ans);
    }

    public static List<int[]> check(int[] position) {
        List<int[]> ret = new ArrayList<int[]>();
        int r = position[0], c = position[1];
        // board[r][c] = 'X';
        for (int[] dir : dirs) {
            int row = r + dir[0], col = c + dir[1];
            List<int[]> tmp = new ArrayList<int[]>();
            while (row >= 0 & row < n & col >= 0 & col < m && board[row][col] == 'O') {
                tmp.add(new int[] { row, col });
                row += dir[0];
                col += dir[1];
            }
            if (row >= 0 & row < n & col >= 0 & col < m && board[row][col] == 'X' & tmp.size() > 0) {
                for (int[] p : tmp)
                    board[p[0]][p[1]] = 'X';
                ret.addAll(tmp);
                for (int[] p : tmp)
                    ret.addAll(check(p));
                // for (int[] p : tmp)
                // board[p[0]][p[1]] = 'O';
            }
        }
        // board[r][c] = '.';
        return ret;
    }
}
