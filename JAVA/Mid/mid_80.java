public class mid_80 {

    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };

        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            nums[slow] = nums[fast];
            slow++;
            if (fast + 1 < nums.length && nums[fast + 1] == nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            int cur = nums[fast];
            while (fast < nums.length && nums[fast] == cur)
                fast++;
        }
        System.out.println(slow);
        for (int i : nums)
            System.out.print(i + " ");
    }
}
