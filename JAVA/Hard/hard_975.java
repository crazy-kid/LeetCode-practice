package JAVA.Hard;

import java.util.Arrays;
import java.util.TreeMap;

public class hard_975 {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 2, 1, 4, 4, 5 };

        int n = arr.length;
        int[] odd = new int[n];
        Arrays.fill(odd, -1);
        int[] even = new int[n];
        Arrays.fill(even, -1);
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        map.put(arr[n - 1], n - 1);

        for (int i = n - 2; i >= 0; i--) {
            if (map.containsKey(arr[i])) {
                odd[i] = map.get(arr[i]);
                even[i] = map.get(arr[i]);
                map.put(arr[i], i);
                continue;
            }
            if (map.higherKey(arr[i]) != null) {
                odd[i] = map.get(map.higherKey(arr[i]));
            }
            if (map.lowerKey(arr[i]) != null) {
                even[i] = map.get(map.lowerKey(arr[i]));
            }
            map.put(arr[i], i);
        }

        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        dp[n - 1][0] = 0;
        dp[n - 1][1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (even[i] != -1 && dp[even[i]][1] != -1)
                dp[i][0] = dp[even[i]][1] + 1;
            if (odd[i] != -1 && dp[odd[i]][0] != -1)
                dp[i][1] = dp[odd[i]][0] + 1;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i][1] != -1)
                ans++;
        }
        System.out.println(ans);
    }
}
