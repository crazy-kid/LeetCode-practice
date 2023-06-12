package JAVA.Mid;

import java.util.Arrays;
import java.util.HashMap;

public class mid_1055 {

    public static void main(String[] args) {
        String source = "aaaaa";
        String target = "aaaaaaaaaaaaa";

        char[] slist = source.toCharArray();
        char[] tlist = target.toCharArray();

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();// 字符在source中出现的最后下标
        for (int i = 0; i < slist.length; i++) {
            map.put(slist[i], i);
        }

        int n = tlist.length;
        int[] dp = new int[n];// dp[i]以target[i]结尾的长度为i+1的自序列串的最短字串数
        Arrays.fill(dp, Integer.MAX_VALUE);
        if (map.containsKey(tlist[0]))
            dp[0] = 1;
        else
            return;

        for (int i = 1; i < n; i++) {
            int cur;// 检索source时的下标
            int l = 1;// 以匹配的字串长度
            if (map.get(tlist[i]) != null)
                cur = map.get(tlist[i]);
            else
                return;
            while (cur >= 0 && i - l >= -1) {
                if (i - l == -1) {
                    dp[i] = 1;
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - l] + 1);// 字串长度为l被匹配
                cur--;
                while (cur >= 0 && tlist[i - l] != slist[cur]) {// 在source中寻找下一个匹配字符
                    cur--;
                }
                l++;
            }
        }
        System.out.println(dp[n - 1]);
    }
}
