public class mid_287 {

    public static void main(String[] args) {
        int nums[] = { 1, 3, 4, 2, 2 };

        for (int i = 1; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i])
                    return;
                else
                    swap(i, nums[i], nums);
            }
        }
        if (nums[nums[0]] == nums[0])
            return;
    }

    public static void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
