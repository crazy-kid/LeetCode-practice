package JAVA.Mid;

public class mid_1658 {

    public static void main(String[] args) {
        int[] nums = { 8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231,
                6309 };
        int x = 134365;

        int max = 0, sum = 0, cur = 0;
        int left = 0, right = -1;
        for (int i : nums)
            sum += i;
        if (sum - x == 0)
            System.out.println(nums.length);
        while (right + 1 < nums.length) {
            cur += nums[++right];
            while (left + 1 <= right && cur > sum - x) {
                cur -= nums[left++];
            }
            if (cur == sum - x)
                max = Math.max(max, right - left + 1);
        }
        if (max != 0)
            System.out.println(nums.length - max);
        else
            System.out.println(-1);
    }
}
