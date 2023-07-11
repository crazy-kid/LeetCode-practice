package JAVA.Mid;

public class mid_1911 {

    public static void main(String[] args) {
        int[] nums = { 6, 2, 1, 2, 4, 5 };

        int n = nums.length;
        // odd[0],even[0]: 上一轮循环的值 odd[1],even[1]当前循环的值
        long[] odd = new long[2];
        long[] even = new long[2];
        for (int i = 0; i < n; i++) {
            odd[1] = Math.max(even[0] - nums[i], odd[0]);
            even[1] = Math.max(odd[0] + nums[i], even[0]);
            odd[0] = odd[1];
            even[0] = even[1];
        }
        System.out.println(Math.max(odd[1], even[1]));
    }
}
