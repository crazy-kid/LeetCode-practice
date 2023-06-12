package JAVA.Mid;

public class mid_153 {

    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 1, 2 };

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[left])
                right = mid;
            else if (nums[mid] > nums[right])
                left = mid + 1;
            else
                break;
        }
        System.out.println(left);
    }
}
