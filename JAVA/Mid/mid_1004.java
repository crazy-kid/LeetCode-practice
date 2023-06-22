package JAVA.Mid;

public class mid_1004 {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;

        int max = 0, zeroCount = 0, left = 0, right = -1;
        while (right + 1 < nums.length) {
            if (nums[++right] == 0) {
                zeroCount++;
                while (zeroCount > k) {
                    if (nums[left++] == 0)
                        zeroCount--;
                }
            }
            max = Math.max(max, right - left + 1);
        }
        System.out.println(max);
    }
}
