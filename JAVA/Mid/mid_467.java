package JAVA.Mid;

import java.util.ArrayList;

public class mid_467 {

    public static void main(String[] args) {
        String s = "cac";

        char[] slist = s.toCharArray();
        int left = 0, right = -1, ans = 0;
        int[] count = new int[26];
        while (++right < slist.length) {
            if (!(right == 0
                    || slist[right] == slist[right - 1] + 1 | (slist[right] == 'a' & slist[right - 1] == 'z'))) {
                left = right;
            }
            count[slist[right] - 'a'] = Math.max(count[slist[right] - 'a'], right - left + 1);
        }
        for (int i : count) {
            ans += i;
        }
        System.out.println(ans);
    }
}
