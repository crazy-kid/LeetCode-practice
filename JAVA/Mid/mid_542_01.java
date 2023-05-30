import java.util.LinkedList;
import java.util.Queue;

public class mid_542_01 {

    public static void main(String[] args) {
        int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 2, 1 } };

        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    int[] tmp = { i, j };
                    queue.offer(tmp);
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = -1; i <= 1; i = i + 2) {
                if (cur[0] + i >= 0 & cur[0] + i < m) {
                    if (mat[cur[0] + i][cur[1]] > mat[cur[0]][cur[1]] + 1) {
                        mat[cur[0] + i][cur[1]] = mat[cur[0]][cur[1]] + 1;
                        int[] tmp = { cur[0] + i, cur[1] };
                        queue.offer(tmp);
                    }
                }
            }
            for (int i = -1; i <= 1; i = i + 2) {
                if (cur[1] + i >= 0 & cur[1] + i < n) {
                    if (mat[cur[0]][cur[1] + i] > mat[cur[0]][cur[1]] + 1) {
                        mat[cur[0]][cur[1] + i] = mat[cur[0]][cur[1]] + 1;
                        int[] tmp = { cur[0], cur[1] + i };
                        queue.offer(tmp);
                    }
                }
            }
        }
        System.out.println();
    }
}
