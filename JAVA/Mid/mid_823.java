package JAVA.Mid;

import java.util.Arrays;
import java.util.HashMap;

public class mid_823 {

    public static void main(String[] args) {
        int[] arr = { 2, 4, 5, 10 };

        final int MOD = (int) 1e9 + 7;
        Arrays.sort(arr);
        int n = arr.length;
        long[] dp = new long[n];
        dp[0] = 1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++)
            map.put(arr[i], i);
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j])) {
                    int k = map.get(arr[i] / arr[j]);
                    dp[i] += dp[j] * dp[k];
                    dp[i] %= MOD;
                }
            }
        }
        long ans = 0;
        for (long i : dp) {
            ans += i;
            ans %= MOD;
        }
        System.out.println(ans);
    }
}
