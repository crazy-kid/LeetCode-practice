public class hard_1121 {

    public static void main(String[] args) {
        int[] nums = { 5, 6, 6, 7, 8 };
        int K = 3;

        int maxLeft = 0;
        int maxRight = 0;
        int tmp = nums[0];
        int tmpLeft = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == tmp) {
                if (i - tmpLeft + 1 > maxRight - maxLeft + 1) {
                    maxLeft = tmpLeft;
                    maxRight = i;
                }
            } else {
                tmpLeft = i;
                tmp = nums[i];
            }
        }
        if ((maxRight - maxLeft + 1) * K > nums.length)
            return;
        return;
    }
}
