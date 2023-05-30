import java.util.HashMap;

public class mid_525 {

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0 };

        int n = nums.length;
        int[] dp = new int[n + 1];
        HashMap<Integer, int[]> map = new HashMap<Integer, int[]>();
        int[] first = { 0, 0 };
        map.put(0, first);
        for (int i = 1; i < dp.length; i++) {
            if (nums[i - 1] == 1)
                dp[i] = dp[i - 1] + 1;
            else
                dp[i] = dp[i - 1] - 1;
            if (map.containsKey(dp[i])) {
                map.get(dp[i])[1] = i;
            } else {
                int[] tmp = { i, i };
                map.put(dp[i], tmp);
            }
        }
        int max = 0;
        for (int key : map.keySet()) {
            if (map.get(key)[1] - map.get(key)[0] > max) {
                max = map.get(key)[1] - map.get(key)[0];
            }
        }
        System.out.println(max);
    }
}
