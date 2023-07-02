package JAVA.Hard;

import java.util.Arrays;
import java.util.Stack;

public class hard_85 {

    public static void main(String[] args) {
        char[][] matrix = {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] nextZero = new int[m][n];
        for (int row = 0; row < m; row++) {
            int cur = n;
            Arrays.fill(nextZero[row], n);
            for (int col = n - 1; col >= 0; col--) {
                if (matrix[row][col] == '0')
                    cur = col;
                nextZero[row][col] = cur;
            }
        }

        int ans = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int col = 0; col < n; col++) {
            int[] up = new int[m];
            int[] down = new int[m];
            Arrays.fill(up, -1);
            Arrays.fill(down, m);
            stack.clear();
            for (int row = 0; row < m; row++) {
                while (!stack.isEmpty() && nextZero[stack.peek()][col] > nextZero[row][col]) {
                    down[stack.pop()] = row;
                }
                if (!stack.isEmpty()) {
                    up[row] = nextZero[stack.peek()][col] < nextZero[row][col] ? stack.peek()
                            : up[stack.peek()];
                }
                stack.push(row);
            }
            for (int row = 0; row < m; row++) {
                int u = up[row] + 1, d = down[row] - 1;
                ans = Math.max(ans, (nextZero[row][col] - col) * (d - u + 1));
            }
        }
        System.out.println(ans);
    }
}
