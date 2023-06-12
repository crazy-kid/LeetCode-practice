package JAVA.Mid;

public class mid_912 {

    public static void main(String[] args) {
        int[] nums = { 5, 2, 3, 1 };
        quickSort(0, nums.length - 1, nums);
        for (int i : nums)
            System.out.println(i);

    }

    public static void quickSort(int left, int right, int[] nums) {
        if (left >= right)
            return;
        int i = left;
        int j = right;
        while (i < j) {
            while (j > i && nums[j] >= nums[left])
                j--;
            while (i < j && nums[i] <= nums[left])
                i++;
            swap(i, j, nums);
        }
        swap(left, i, nums);
        quickSort(left, i - 1, nums);
        quickSort(i + 1, right, nums);
    }

    public static void swap(int i1, int i2, int[] nums) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}
