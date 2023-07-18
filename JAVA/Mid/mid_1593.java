package JAVA.Mid;

import java.util.HashSet;

public class mid_1593 {

    public static int ans = 0;
    public static HashSet<String> set = new HashSet<String>();

    public static void main(String[] args) {
        String s = "ababccc";

        dfs(s, 0);
        System.out.println(ans);
    }

    public static void dfs(String str, int begin) {
        if (begin == str.length()) {
            ans = Math.max(ans, set.size());
            return;
        }
        for (int end = begin; end < str.length(); end++) {
            if (set.contains(str.substring(begin, end + 1)))
                continue;
            else {
                set.add(str.substring(begin, end + 1));
                dfs(str, end + 1);
                set.remove(str.substring(begin, end + 1));
            }
        }
    }
}
