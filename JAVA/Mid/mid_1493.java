package JAVA.Mid;

public class mid_1493 {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1 };

        int left = 0, right = -1, zeroCount = 0, max = 0;
        while (right + 1 < nums.length) {
            if (nums[++right] == 0)
                zeroCount++;
            while (zeroCount > 1) {
                if (nums[left++] == 0)
                    zeroCount--;
            }
            max = Math.max(right - left + 1, max);
        }
        if (zeroCount == 0)
            System.out.println(max - 1);
        else
            return;
    }
}
