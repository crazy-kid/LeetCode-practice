public class mid_396 {
    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 6 };
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            max += i * nums[i];
            sum += nums[i];
        }

        int cur = max;
        for (int i = 0; i < nums.length - 1; i++) {
            cur += sum - nums.length * nums[nums.length - 1 - i];
            max = Math.max(max, cur);
        }

        System.out.print(max);
    }
}
