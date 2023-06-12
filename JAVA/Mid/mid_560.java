package JAVA.Mid;

import java.util.HashMap;

public class mid_560 {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1 };
        int k = 2;

        int n = nums.length;
        int ans = 0;
        int[] preSum = new int[n + 1];
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        count.put(0, 1);
        for (int i = 1; i < n + 1; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            if (count.containsKey(preSum[i] - k)) {
                ans += count.get(preSum[i] - k);
            }
            if (count.containsKey(preSum[i]))
                count.put(preSum[i], count.get(preSum[i]) + 1);
            else
                count.put(preSum[i], 1);
        }
        System.out.println(ans);
    }
}
