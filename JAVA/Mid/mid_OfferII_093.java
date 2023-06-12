package JAVA.Mid;

import java.util.Arrays;
import java.util.HashMap;

public class mid_OfferII_093 {

    public static void main(String[] args) {
        int[] nums = { 2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50 };

        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();// num to index
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 2);
        }
        for (int j = 2; j < n; j++) {
            for (int i = 1; i < j; i++) {
                int tmp = nums[j] - nums[i];
                if (map.containsKey(tmp) & tmp < nums[i]) {
                    int k = map.get(tmp);
                    dp[i][j] = dp[k][i] + 1;
                }
            }
        }

        int max = 0;
        for (int j = 2; j < n; j++) {
            for (int i = 1; i < j; i++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        if (max == 2)
            return;
        System.out.println(max);
    }

}
