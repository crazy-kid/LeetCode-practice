public class mid_209 {

    public static void main(String[] args) {
        int target = 7;
        int[] nums = { 2, 3, 1, 2, 4, 3 };

        int slow = 0;
        int fast = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while (fast < nums.length) {
            sum += nums[fast];
            if (sum >= target)
                len = Math.min(len, fast - slow + 1);
            while (slow < fast & sum - nums[slow] >= target) {
                sum -= nums[slow];
                slow++;
                len = Math.min(len, fast - slow + 1);
            }
            fast++;
        }

        System.out.println(len);
    }
}
