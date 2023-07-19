package JAVA.Mid;

import java.util.HashSet;

public class mid_874 {
    public static int[] commands = { 4, -1, 3 };
    public static int[][] obstacles = {};

    public static int[][] orient = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    public static HashSet<String> set = new HashSet<String>();

    public static void main(String[] args) {
        for (int[] cor : obstacles)
            set.add(hashKey(cor[0], cor[1]));
        int[] pos = { 0, 0 };
        int ans = 0, orientId = 0;
        for (int op : commands) {
            if (op < 0)
                orientId = nextOrient(orientId, op);
            else {
                for (int s = 0; s < op; s++) {
                    if (set.contains(hashKey(pos[0] + orient[orientId][0], pos[1] + orient[orientId][1])))
                        break;
                    pos[0] += orient[orientId][0];
                    pos[1] += orient[orientId][1];
                    ans = Math.max(ans, pos[0] * pos[0] + pos[1] * pos[1]);
                }
            }
        }
        System.out.println(ans);
    }

    public static int nextOrient(int i, int op) {
        return op == -1 ? (i + 1) % 4 : (i + 3) % 4;
    }

    public static String hashKey(int row, int col) {
        return Integer.toString(row) + " " + Integer.toString(col);
    }
}
