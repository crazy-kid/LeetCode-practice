package JAVA.Mid;

import java.util.HashSet;

public class mid_1254 {

    public static void main(String[] args) {

        int[][] grid = { { 1, 1, 1, 1, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 0, 1, 1, 0 },
                { 1, 0, 1, 0, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 0 } };

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int m = grid.length;
        int n = grid[0].length;
        int[] root = new int[m * n];
        for (int i = 0; i < root.length; i++)
            root[i] = i;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                for (int[] dir : dirs) {
                    int x = dir[0], y = dir[1];
                    if (row + x >= 0 & row + x < m & col + y >= 0 & col + y < n
                            && grid[row + x][col + y] == grid[row][col]) {
                        union(row * n + col, (row + x) * n + (col + y), root);
                    }
                }
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int row = 0; row < m; row++)
            for (int col = 0; col < n; col++) {
                int tmp = find(row * n + col, root);
                if (grid[row][col] == 0)
                    set.add(tmp);
            }
        for (int col = 0; col < n; col++) {
            if (grid[0][col] == 0)
                set.remove(root[col]);
            if (grid[m - 1][col] == 0)
                set.remove(root[(m - 1) * n + col]);
        }
        for (int row = 0; row < m; row++) {
            if (grid[row][0] == 0)
                set.remove(root[row * n]);
            if (grid[row][n - 1] == 0)
                set.remove(root[row * n + n - 1]);
        }
        System.out.println(set.size());
    }

    public static int find(int child, int[] root) {
        if (child == root[child])
            return child;
        return root[child] = find(root[child], root);
    }

    public static void union(int x, int y, int[] root) {
        int rootX = find(x, root);
        int rootY = find(y, root);
        if (rootX < rootY)
            root[rootY] = rootX;
        else
            root[rootX] = rootY;
    }
}