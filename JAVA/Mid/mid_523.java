import java.util.HashSet;

public class mid_523 {

    public static void main(String[] args) {
        int[] nums = { 23, 2, 4, 6, 7 };
        int k = 6;

        HashSet<Integer> set = new HashSet<Integer>();
        set.add(0);
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if (set.contains(sum % k)) {
                System.out.println(i);
                return;
            } else
                set.add((sum - nums[i]) % k);
        }
    }
}
