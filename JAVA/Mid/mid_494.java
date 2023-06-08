public class mid_494 {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1, 1 };
        int target = 3;

        int ans = backTrack(nums, 0, target);
        System.out.println(ans);
    }

    public static int backTrack(int[] nums, int start, int target) {
        if (start == nums.length) {
            if (target == 0)
                return 1;
            else
                return 0;
        }

        int ret = 0;
        ret += backTrack(nums, start + 1, target - nums[start]);// 当前数字选择+
        ret += backTrack(nums, start + 1, target + nums[start]);// 当前数字选择-
        return ret;
    }
}
