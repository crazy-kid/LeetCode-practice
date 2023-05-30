public class mid_360 {

    public static void main(String[] args) {
        int[] nums = { -4, -2, 2, 4 };

        int a = 0;
        int b = -1;
        int c = 5;

        int[] ans = new int[nums.length];
        float mid = -(float) b / 2 * a;

        int left = 0;
        int right = nums.length - 1;
        int cur = nums.length - 1;
        int d = -1;
        if (a == 0) {
            if (b > 0) {
                d = 1;
                cur = 0;
            }
            for (int i = 0; i < nums.length; i++) {
                ans[cur] = b * nums[i] + c;
                cur += d;
            }
            for (int e : ans) {
                System.out.print(" " + e);
            }
            return;
        }
        if (a < 0) {
            d = 1;
            cur = 0;
        }
        while (left <= right) {
            if (Math.abs(mid - nums[left]) <= Math.abs(nums[right] - mid)) {
                ans[cur] = a * nums[right] * nums[right] + b * nums[right] + c;
                right--;
                cur += d;
            } else {
                ans[cur] = a * nums[left] * nums[left] + b * nums[left] + c;
                left++;
                cur += d;
            }
        }

        for (int e : ans) {
            System.out.print(" " + e);
        }
    }
}
