package JAVA.Hard;

public class hard_41 {

    public static void main(String[] args) {
        int[] nums = { 3, 4, -1, 1 };

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0 && nums[i] <= n && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
                i--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 != i) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(n + 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
