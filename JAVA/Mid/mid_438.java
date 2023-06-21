package JAVA.Mid;

import java.util.ArrayList;
import java.util.List;

public class mid_438 {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> list = new ArrayList<>();
        int[] count = new int[26];
        for (char c : p.toCharArray())
            count[c - 97]++;
        int left = 0, right = -1;
        int plen = p.length();
        while (right + 1 < s.length()) {
            if (--count[s.charAt(++right) - 97] >= 0) {
                plen--;
            }
            if (right - left + 1 > p.length()) {
                if (++count[s.charAt(left++) - 97] > 0)
                    plen++;
            }
            if (plen == 0) {
                list.add(left);
            }
        }
        for (int i : list)
            System.out.print(i + " ");
    }
}
