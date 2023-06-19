package JAVA.Mid;

public class mid_75 {

    public static void main(String[] args) {
        int[] nums = { 2, 0, 2, 1, 1, 0 };

        int zero = -1;
        int one = -1;
        int cur = 0;
        while (cur < nums.length) {
            switch (nums[cur]) {
                case 0:
                    nums[cur] = 2;
                    nums[++one] = 1;
                    nums[++zero] = 0;
                    break;
                case 1:
                    nums[cur] = 2;
                    nums[++one] = 1;
                    break;
                default:
                    break;
            }
            cur++;
        }
        for (int i : nums)
            System.out.print(i + " ");
    }
}
