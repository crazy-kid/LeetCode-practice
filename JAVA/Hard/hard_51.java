package JAVA.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class hard_51 {

    public static void main(String[] args) {
        int n = 4;

        List<List<String>> ans = new ArrayList<List<String>>();
        int[] position = new int[n];
        Arrays.fill(position, -1);
        backTrack(position, ans);

        for (List<String> l : ans) {
            for (String str : l) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

    public static void backTrack(int[] position, List<List<String>> ans) {
        int n = position.length;
        int next = 0;
        while (next < n && position[next] != -1)
            next++;
        if (next == n) {
            ans.add(solu(position));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (vaild(position, next, col)) {
                position[next] = col;
                backTrack(position, ans);
                position[next] = -1;
            }
        }
    }

    public static boolean vaild(int[] position, int r, int c) {
        int n = position.length;
        for (int row = 0; row < n; row++) {
            if (position[row] == -1)
                break;
            if (position[row] == c | row + position[row] == r + c | row - position[row] == r - c) {
                return false;
            }
        }
        return true;
    }

    public static List<String> solu(int[] position) {
        int n = position.length;
        List<String> list = new ArrayList<String>();
        for (int col : position) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < col; i++)
                s.append('.');
            s.append('Q');
            for (int i = col + 1; i < n; i++) {
                s.append('.');
            }
            list.add(s.toString());
        }
        return list;
    }
}
