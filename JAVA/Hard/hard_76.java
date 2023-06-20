package JAVA.Hard;

import java.util.HashMap;

public class hard_76 {
    public static HashMap<Character, Integer> target = new HashMap<Character, Integer>();
    public static HashMap<Character, Integer> count = new HashMap<Character, Integer>();

    public static void main(String[] args) {
        String s = "a";
        String t = "aa";

        char[] slist = s.toCharArray();
        char[] tlist = t.toCharArray();
        for (char c : tlist) {
            int n = target.getOrDefault(c, 0);
            target.put(c, n + 1);
        }
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int[] ans = new int[] { -1, -1 };
        while (right < slist.length) {
            count.put(slist[right], count.getOrDefault(slist[right], 0) + 1);
            while (isValid()) {
                if (min > right - left + 1) {
                    min = right - left + 1;
                    ans[0] = left;
                    ans[1] = right;
                }
                count.put(slist[left], count.get(slist[left]) - 1);
                left++;
            }
            right++;
        }
        if (ans[0] == -1)
            return;
        System.out.println(s.substring(ans[0], ans[1] + 1));
    }

    public static boolean isValid() {
        for (char key : target.keySet())
            if (count.getOrDefault(key, 0) < target.get(key))
                return false;
        return true;

    }
}
