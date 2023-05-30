import java.util.Arrays;

public class easy_594 {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 2, 5, 2, 3, 7 };
        Arrays.sort(nums);
        int ans = 0;
        int ln = 0;
        int hn = 0;
        int low = nums[0];
        for (int num : nums) {
            if (num == low) {
                ln++;
                ans = Math.max(ans, ln);
                continue;
            }
            if (num == low + 1) {
                hn++;
                ans = Math.max(ans, ln + hn);
                continue;
            }
            if (num == low + 2) {
                ln = hn;
                hn = 1;
                low = low + 1;
                ans = Math.max(ans, ln + hn);
                continue;
            }
            ln = 1;
            low = num;
            hn = 0;
            ans = Math.max(ans, ln + hn);
        }
        System.out.println(ans);
    }
}