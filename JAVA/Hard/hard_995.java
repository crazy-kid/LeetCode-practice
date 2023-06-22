package JAVA.Hard;

public class hard_995 {

    public static void main(String[] args) {
        int[] nums = { 0, 0, 0, 1, 0, 1, 1, 0 };
        int k = 3;

        int left = 0;
        int ans = 0;
        while (left < nums.length) {
            while (left < nums.length && nums[left] == 1)
                left++;
            if (left >= nums.length)
                return;
            for (int i = 0; i < k; i++) {
                if (left + i >= nums.length)
                    return;
                else
                    nums[left + i] = 1 - nums[left + i];
            }
            ans++;
        }
        System.out.println(ans);
    }
}
