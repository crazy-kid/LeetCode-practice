package JAVA.Mid;

import java.util.HashMap;

public class mid_974 {

    public static void main(String[] args) {
        int[] nums = { -1, 2, 9 };
        int k = 2;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int j = ((sum % k) + k) % k;
            if (map.containsKey(j)) {
                int tmp = map.get(j);
                ans += tmp;
                map.put(j, tmp + 1);
            } else
                map.put(j, 1);
        }
        System.out.println(ans);
    }
}
