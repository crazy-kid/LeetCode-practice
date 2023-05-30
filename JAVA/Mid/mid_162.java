public class mid_162 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 3, 5, 6, 4 };

        int n = nums.length;
        int right = n - 1;
        int left = 0;
        int mid = (left + right) / 2;

        int n1;
        int n2;

        while (right > left) {
            mid = (left + right) / 2;
            if (mid - 1 >= 0)
                n1 = nums[mid - 1];
            else
                n1 = Integer.MIN_VALUE;
            if (mid + 1 < n)
                n2 = nums[mid + 1];
            else
                n2 = Integer.MIN_VALUE;
            if (n1 < nums[mid] & n2 < nums[mid])
                return;
            if (n1 > nums[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
    }
}
