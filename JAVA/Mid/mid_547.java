package JAVA.Mid;

public class mid_547 {
    static int[] root;

    public static void main(String[] args) {
        int[][] isConnected = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

        int n = isConnected.length;
        root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < row; col++) {
                if (isConnected[row][col] == 1)
                    union(row, col);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i == find(i))
                ans++;
        }
        System.out.println(ans);
    }

    public static int find(int child) {
        if (root[child] == child)
            return child;
        return root[child] = find(root[child]);
    }

    public static void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        int tmp = Math.min(rootx, rooty);
        root[rootx] = tmp;
        root[rooty] = tmp;
    }
}
