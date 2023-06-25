package JAVA.Mid;

public class mid_713 {

    public static void main(String[] args) {
        int[] nums = { 9, 4, 3, 2, 6, 2, 5, 4, 2, 6, 7 };
        int k = 144;

        int left = 0, right = -1, ans = 0, cur = 1;
        while (++right < nums.length) {
            cur *= nums[right];
            while (cur >= k & left <= right) {
                cur /= nums[left++];
            }
            ans += right - left + 1;
        }
        System.out.println(ans);
    }
}
