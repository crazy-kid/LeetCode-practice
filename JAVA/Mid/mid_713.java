package JAVA.Mid;

public class mid_713 {

    public static void main(String[] args) {
        int[] nums = { 9, 4, 3, 2, 6, 2, 5, 4, 2, 6, 7 };
        int k = 144;

        int n = nums.length;
        double[] preMul = new double[n + 1];
        preMul[0] = 0;
        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            preMul[i] = preMul[i - 1] + Math.log(nums[i - 1]);
            if (preMul[i] < Math.log(k))
                ans += i;
            else {
                int index = binarySearch(0, i, preMul[i] - Math.log(k) + 0.0001, preMul);
                if (index < i) {
                    ans += i - index;
                }
            }
        }
        System.out.println(ans);
    }

    public static int binarySearch(int left, int right, double target, double[] array) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] > target)
                right = mid;
            else
                left = mid + 1;
        }
        return right;
    }
}
