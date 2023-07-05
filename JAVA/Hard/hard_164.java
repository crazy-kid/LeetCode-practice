package JAVA.Hard;

import java.util.Arrays;

public class hard_164 {
    public static void main(String[] args) {
        int[] nums = { 3, 6, 9, 1 };

        int n = nums.length;
        if (n <= 1)
            return;
        int min = Integer.MAX_VALUE, max = 0;
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int ans = 0, size = (int) Math.ceil((max - min + 1.0) / n);
        int[][] buckets = new int[n][2];
        for (int[] l : buckets)
            Arrays.fill(l, -1);
        for (int num : nums) {
            int index = (num - min) / size;
            if (buckets[index][0] == -1 || buckets[index][0] > num)
                buckets[index][0] = num;
            if (buckets[index][1] == -1 || buckets[index][1] < num)
                buckets[index][1] = num;
        }
        int pre = -1;
        for (int i = 0; i < n; i++) {
            if (buckets[i][0] == -1)
                continue;
            ans = Math.max(ans, buckets[i][1] - buckets[i][0]);
            if (pre != -1) {
                ans = Math.max(ans, buckets[i][0] - buckets[pre][1]);
            }
            pre = i;
        }
        System.out.println(ans);
    }
}
