package JAVA.Mid;

public class mid_167 {

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        for (int i = 0; i < nums.length - 1; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int t = target - nums[i];
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] >= t) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (nums[left] == t) {
                System.out.println(i + " " + left);
                return;
            }
        }
    }
}
