import java.util.Arrays;
import java.util.HashMap;

public class hard_132 {
BUG
    public static void main(String[] args) {
        String s = "aaaaaaa";

        char[] clist = s.toCharArray();
        int n = clist.length;
        HashMap<Integer, Integer> oddMap = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> evenMap = new HashMap<Integer, Integer>();

        // 初始化回文字串map
        for (int i = 0; i < n; i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 & right < n) {
                if (clist[left] != clist[right]) {
                    break;
                }
                left--;
                right++;
            }
            if (right - 1 - i > 0)
                oddMap.put(i, right - 1 - i);
            if (i + 1 < n && clist[i + 1] == clist[i]) {
                left = i;
                right = i + 1;
                evenMap.put(i, 1);
                while (left >= 0 & right < n) {
                    if (clist[left] != clist[right]) {
                        break;
                    }
                    left--;
                    right++;
                }
                evenMap.put(i, right - 1 - i);
            }
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int right = 2; right < n + 1; right++) {
            dp[right] = dp[right - 1] + 1;
            for (int left = right - 1; left >= 1; left--) {
                int mid = (left + right) / 2;
                if (oddMap.containsKey(mid - 1) && oddMap.get(mid - 1) >= right - mid) {
                    dp[right] = Math.min(dp[right], dp[left - 1] + 1);
                }
                if (evenMap.containsKey(mid - 1) && (right - left) % 2 == 1 && evenMap.get(mid - 1) >= right - mid) {
                    dp[right] = Math.min(dp[right], dp[left - 1] + 1);
                }
            }
        }
        System.out.println(dp[n] - 1);
    }
}
