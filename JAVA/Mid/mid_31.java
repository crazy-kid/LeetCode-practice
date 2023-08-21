package JAVA.Mid;

public class mid_31 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };

        int n = nums.length, i = n - 1;
        while (i >= 1) {
            if (nums[i - 1] < nums[i])
                break;
            i--;
        }
        if (i <= 0) {
            reverse(nums, 0, n - 1);
            return;
        }
        i--;
        for (int j = n - 1; j > i; j--)
            if (nums[j] > nums[i]) {
                swap(nums, i, j);
                break;
            }
        reverse(nums, i + 1, n - 1);
        for (int num : nums)
            System.out.print(num + " ");
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void reverse(int[] nums, int i, int j) {
        while (j > i)
            swap(nums, i++, j--);
    }
}
