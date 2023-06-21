package JAVA.Mid;

import java.util.HashSet;

public class mid_1695 {

    public static void main(String[] args) {
        int[] nums = { 5, 2, 1, 2, 5, 2, 1, 2, 5 };

        int left = 0, right = -1;
        int ans = 0, cur = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        while (right + 1 < nums.length) {
            if (set.contains(nums[right + 1])) {
                while (nums[left] != nums[right + 1]) {
                    set.remove(nums[left]);
                    cur -= nums[left];
                    left++;
                }
                left++;
            } else {
                set.add(nums[right + 1]);
                cur += nums[right + 1];
                ans = Math.max(ans, cur);
            }
            right++;
        }
        System.out.println(ans);
    }
}
