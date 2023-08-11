package JAVA.Mid;

public class mid_376 {

    public static void main(String[] args) {
        int[] nums = { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
        if (nums.length == 1)
            return;
        int slow = 0, fast = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        int n = slow + 1;
        if (n <= 2)
            return;

        boolean up = false;
        int ans = 1, cur = 0;
        if (nums[1] > nums[0])
            up = true;
        while (cur < n) {
            if (up) {
                if (cur + 1 < n && nums[cur + 1] > nums[cur]) {
                    ans++;
                    up = !up;
                }
            } else {
                if (cur + 1 < n && nums[cur + 1] < nums[cur]) {
                    ans++;
                    up = !up;
                }
            }
            cur++;
        }
        System.out.println(ans);
    }
}
