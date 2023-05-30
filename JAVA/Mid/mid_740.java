import java.util.Arrays;
import java.util.HashMap;

public class mid_740 {

    public static void main(String[] args) {
        int[] nums = { 2, 2, 3, 3, 3, 4 };

        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (count.containsKey(num)) {
                count.put(num, count.get(num) + 1);
            } else {
                count.put(num, 1);
            }
        }

        int[] list = new int[count.size()];
        int j = 0;
        for (int key : count.keySet()) {
            list[j] = key;
            j++;
        }

        Arrays.sort(list);
        int n = list.length;
        int[] dp1 = new int[n];
        int[] dp0 = new int[n];
        dp1[0] = list[0] * count.get(list[0]);
        for (int i = 1; i < n; i++) {
            if (list[i - 1] + 1 == list[i]) {
                dp1[i] = list[i] * count.get(list[i]) + dp0[i - 1];
            } else {
                dp1[i] = Math.max(dp1[i - 1], dp0[i - 1]) + list[i] * count.get(list[i]);
            }
            dp0[i] = Math.max(dp1[i - 1], dp0[i - 1]);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp1[i]);
            max = Math.max(max, dp0[i]);
        }
        System.out.println(max);
    }
}
