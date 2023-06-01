public class easy_169 {

    public static void main(String[] args) {
        int[] nums = { 3, 3, 4 };

        int ans = nums[0];
        int count = 0;
        for (int i : nums) {
            if (count == 0)
                ans = i;
            if (i == ans)
                count++;
            else
                count--;
        }
        System.out.println(ans);
    }
}
