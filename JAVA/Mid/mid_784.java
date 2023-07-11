package JAVA.Mid;

import java.util.ArrayList;
import java.util.List;

public class mid_784 {

    public static void main(String[] args) {
        String s = "a1b2";

        List<String> ans = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        char[] clist = s.toCharArray();
        dfs(clist, 0, ans, sb);
        for (String str : ans)
            System.out.println(str);
    }

    public static void dfs(char[] list, int cur, List<String> ans, StringBuilder sb) {
        if (cur == list.length) {
            ans.add(sb.toString());
            return;
        }
        if (Character.isAlphabetic(list[cur])) {
            sb.append(Character.toUpperCase(list[cur]));
            dfs(list, cur + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(Character.toLowerCase(list[cur]));
            dfs(list, cur + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(list[cur]);
            dfs(list, cur + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
