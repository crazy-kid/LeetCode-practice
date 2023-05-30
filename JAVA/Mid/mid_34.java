import java.util.Arrays;

public class mid_34 {

    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 6;

        int[] ans = new int[2];
        Arrays.fill(ans, -1);
        if (target > nums[nums.length - 1] | target < nums[0])
            return;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] <= target)
                left = mid;
            else
                right = mid - 1;
        }
        if (nums[right] == target)
            ans[1] = right;

        left = 0;
        right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target)
                right = mid;
            else
                left = mid + 1;
        }
        if (nums[left] == target)
            ans[0] = left;
        for (int i : ans)
            System.out.println(i);
    }
}
