package JAVA.Mid;

import java.util.Arrays;

class mid_611 {
    public static void main(String[] args) {
        int[] nums = { 4, 2, 3, 4 };

        if (nums.length < 3)
            return;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int num1 = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int num2 = nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    int num3 = nums[k];
                    if (num1 + num2 > num3)
                        ans++;
                    else
                        break;
                }
            }
        }
        System.out.println(ans);
    }
}