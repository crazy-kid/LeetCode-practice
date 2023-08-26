package JAVA.Mid;

import java.util.ArrayList;
import java.util.List;

public class mid_131 {

    static boolean[][] isCircle;
    static String s;
    static char[] slist;
    static int n;
    static List<List<String>> ans;

    public static void main(String[] args) {
        s = "aab";
        slist = s.toCharArray();
        n = slist.length;
        // pre
        isCircle = new boolean[n][n];
        for (int start = 0; start < n; start++)
            for (int end = 0; end <= start; end++)
                isCircle[start][end] = true;
        for (int len = 2; len <= n; len++) {
            for (int start = 0; start + len - 1 < n; start++) {
                int end = start + len - 1;
                if (slist[start] == slist[end] & isCircle[start + 1][end - 1])
                    isCircle[start][end] = true;
            }
        }
        ans = new ArrayList<List<String>>();
        List<String> cur = new ArrayList<String>();
        dfs(0, cur);
        for (List<String> l : ans) {
            for (String str : l)
                System.out.print(" " + str);
            System.out.println();
        }
    }

    public static void dfs(int start, List<String> list) {
        if (start == n) {
            List<String> tmp = new ArrayList<String>();
            tmp.addAll(list);
            ans.add(tmp);
        }
        for (int end = start; end < n; end++) {
            if (isCircle[start][end]) {
                list.add(s.substring(start, end + 1));
                dfs(end + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
