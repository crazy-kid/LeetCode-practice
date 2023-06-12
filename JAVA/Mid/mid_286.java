package JAVA.Mid;

import java.util.LinkedList;
import java.util.Queue;

public class mid_286 {

    public static void main(String[] args) {
        int[][] rooms = { { 2147483647, -1, 0, 2147483647 },
                { 2147483647, 2147483647, 2147483647, -1 },
                { 2147483647, -1, 2147483647, -1 },
                { 0, -1, 2147483647, 2147483647 } };
        int m = rooms.length;
        int n = rooms[0].length;

        Queue<int[]> queue = new LinkedList<int[]>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == 0) {
                    queue.clear();
                    queue.add(new int[] { row, col });
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        if (cur[0] - 1 >= 0 && rooms[cur[0]][cur[1]] + 1 < rooms[cur[0] - 1][cur[1]]) {
                            rooms[cur[0] - 1][cur[1]] = rooms[cur[0]][cur[1]] + 1;
                            queue.add(new int[] { cur[0] - 1, cur[1] });
                        }
                        if (cur[0] + 1 < m && rooms[cur[0]][cur[1]] + 1 < rooms[cur[0] + 1][cur[1]]) {
                            rooms[cur[0] + 1][cur[1]] = rooms[cur[0]][cur[1]] + 1;
                            queue.add(new int[] { cur[0] + 1, cur[1] });
                        }
                        if (cur[1] - 1 >= 0 && rooms[cur[0]][cur[1]] + 1 < rooms[cur[0]][cur[1] - 1]) {
                            rooms[cur[0]][cur[1] - 1] = rooms[cur[0]][cur[1]] + 1;
                            queue.add(new int[] { cur[0], cur[1] - 1 });
                        }
                        if (cur[1] + 1 < n && rooms[cur[0]][cur[1]] + 1 < rooms[cur[0]][cur[1] + 1]) {
                            rooms[cur[0]][cur[1] + 1] = rooms[cur[0]][cur[1]] + 1;
                            queue.add(new int[] { cur[0], cur[1] + 1 });
                        }
                    }
                }
            }
        }
        for (int[] row : rooms) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
