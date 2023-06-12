package JAVA.Mid;

import java.util.HashMap;

public class mid_3 {

    public static void main(String[] args) {
        String s = "abcabcbb";

        char[] clist = s.toCharArray();
        int[] dp = new int[clist.length + 1];
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < clist.length; i++) {
            int preIndex = -1000000;
            if (map.containsKey(clist[i]))
                preIndex = map.get(clist[i]);
            dp[i + 1] = Math.min(dp[i] + 1, i - preIndex);
            map.put(clist[i], i);
        }
        int ans = 0;
        for (int i : dp) {
            ans = Math.max(ans, i);
        }
        System.out.println(ans);
    }
}
