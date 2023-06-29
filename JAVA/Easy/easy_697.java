package JAVA.Easy;

import java.util.HashMap;

public class easy_697 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 3, 1 };

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> begin = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> end = new HashMap<Integer, Integer>();

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
                end.put(nums[i], i);
            } else {
                map.put(nums[i], 1);
                end.put(nums[i], i);
                begin.put(nums[i], i);
            }
            max = Math.max(max, map.get(nums[i]));
        }

        int ans = Integer.MAX_VALUE;
        for (int key : map.keySet()) {
            if (max == map.get(key)) {
                ans = Math.min(end.get(key) - begin.get(key), ans);
            }
        }
        ans++;
        System.out.println(ans);
    }

}
