package JAVA.Hard;

import java.util.Arrays;

public class hard_727 {

    public static void main(String[] args) {
        String s1 = "ffffeesssa";
        String s2 = "fffessa";

        int n = s1.length();
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        int[][] next = new int[n][26];
        for (int i = n - 1; i > 0; i--) {
            char c = s1.charAt(i);
            pos[c - 'a'] = i;
            next[i - 1] = pos.clone();
        }

        int[] ans = { -1, n };
        for (int left = 0; left <= n - s2.length(); left++) {
            if (s1.charAt(left) == s2.charAt(0)) {
                boolean finded = true;
                int cur = left;
                for (int i = 1; i < s2.length(); i++) {
                    if (next[cur][s2.charAt(i) - 'a'] > 0) {
                        cur = next[cur][s2.charAt(i) - 'a'];
                    } else {
                        finded = false;
                        break;
                    }
                }
                if (finded & cur - left + 1 < ans[1] - ans[0] + 1) {
                    ans[0] = left;
                    ans[1] = cur;
                }
            }
        }
        System.out.println(s1.substring(ans[0], ans[1] + 1));
    }
}
