import java.util.HashSet;

public class mid_325 {

    public static void main(String[] args) {
        int[] nums = { -2, -1, 2, 1 };
        int k = 1;

        int[] preSum = new int[nums.length + 1];
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(0);
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            set.add(preSum[i]);
            if (set.contains(preSum[i] - k)) {
                for (int j = 0; j < i; j++) {
                    if (preSum[i] - preSum[j] == k)
                        System.out.println(j + " " + i);
                }
            }
        }

    }
}
