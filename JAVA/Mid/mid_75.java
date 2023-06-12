package JAVA.Mid;

public class mid_75 {

    public static void main(String[] args) {
        int[] nums = { 2, 0, 2, 1, 1, 0 };

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < nums.length && nums[left] == 0)
                left++;
            while (right >= 0 && nums[right] != 0)
                right--;
            if (left < right)
                swap(left, right, nums);
        }
        left = 0;
        right = nums.length - 1;
        while (left < right) {
            while (left < nums.length && nums[left] <= 1)
                left++;
            while (right >= 0 && nums[right] == 2)
                right--;
            if (left < right)
                swap(left, right, nums);
        }
        for (int i : nums)
            System.out.println(i);
    }

    public static void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
