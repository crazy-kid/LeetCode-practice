import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class mid_752 {

    public static void main(String[] args) {
        String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
        String target = "0202";

        int n = 10;
        int[][][][] mat = new int[n][n][n][n];
        for (int[][][] i : mat)
            for (int[][] j : i)
                for (int[] k : j)
                    Arrays.fill(k, Integer.MAX_VALUE);
        mat[0][0][0][0] = 0;
        for (String str : deadends) {
            if (str.equals("0000"))
                return;
            mat[str.charAt(0) - 48][str.charAt(1) - 48][str.charAt(2) - 48][str.charAt(3) - 48] = -1;
        }

        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[] { 0, 0, 0, 0 });
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == target.charAt(0) - 48 && cur[1] == target.charAt(1) - 48 && cur[2] == target.charAt(2) - 48
                    && cur[3] == target.charAt(3) - 48) {
                System.out.println(mat[cur[0]][cur[1]][cur[2]][cur[3]]);
                return;
            }
            for (int bias : new int[] { -1, 1 }) {
                if (mat[(cur[0] + bias + n) % n][cur[1]][cur[2]][cur[3]] > mat[cur[0]][cur[1]][cur[2]][cur[3]]
                        + 1) {
                    mat[(cur[0] + bias + n) % n][cur[1]][cur[2]][cur[3]] = mat[cur[0]][cur[1]][cur[2]][cur[3]] + 1;
                    queue.add(new int[] { (cur[0] + bias + n) % n, cur[1], cur[2], cur[3] });
                }
                if (mat[cur[0]][(cur[1] + bias + n) % n][cur[2]][cur[3]] > mat[cur[0]][cur[1]][cur[2]][cur[3]]
                        + 1) {
                    mat[cur[0]][(cur[1] + bias + n) % n][cur[2]][cur[3]] = mat[cur[0]][cur[1]][cur[2]][cur[3]] + 1;
                    queue.add(new int[] { cur[0], (cur[1] + bias + n) % n, cur[2], cur[3] });
                }
                if (mat[cur[0]][cur[1]][(cur[2] + bias + n) % n][cur[3]] > mat[cur[0]][cur[1]][cur[2]][cur[3]] + 1) {
                    mat[cur[0]][cur[1]][(cur[2] + bias + n) % n][cur[3]] = mat[cur[0]][cur[1]][cur[2]][cur[3]] + 1;
                    queue.add(new int[] { cur[0], cur[1], (cur[2] + bias + n) % n, cur[3] });
                }
                if (mat[cur[0]][cur[1]][cur[2]][(cur[3] + bias + n) % n] > mat[cur[0]][cur[1]][cur[2]][cur[3]] + 1) {
                    mat[cur[0]][cur[1]][cur[2]][(cur[3] + bias + n) % n] = mat[cur[0]][cur[1]][cur[2]][cur[3]] + 1;
                    queue.add(new int[] { cur[0], cur[1], cur[2], (cur[3] + bias + n) % n });
                }
            }
        }
    }
}
