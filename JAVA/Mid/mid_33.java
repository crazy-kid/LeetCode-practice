public class mid_33 {

    public static void main(String[] args) {
        int[] nums = { 1, 3 };
        int target = 1;

        int n = nums.length;
        int k = 0;
        for (int i = 1; i < n; i++)
            if (nums[i - 1] > nums[i])
                k = i;

        if (target < nums[k])
            return;
        if (target > nums[(k - 1 + n) % n])
            return;

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            int num = nums[(mid + k) % n];
            if (num < target)
                left = mid + 1;
            else
                right = mid;
        }
        if (nums[(right + k) % n] == target)
            System.out.println((right + k) % n);
    }
}
