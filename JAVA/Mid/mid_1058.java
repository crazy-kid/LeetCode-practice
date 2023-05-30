import java.util.Arrays;

public class mid_1058 {

    public static void main(String[] args) {
        String[] prices = { "2.000", "2.000", "2.000", "2.000", "2.000" };
        int target = 10;

        float[] nums = new float[prices.length];
        float[] p = new float[prices.length];
        int diff = 0;
        int down = 0;
        for (int i = 0; i < prices.length; i++) {
            nums[i] = Float.parseFloat(prices[i]);
            if (nums[i] - (int) nums[i] > 0.0001) {
                diff++;
                p[i] = nums[i] - (int) nums[i];
            }
            down += (int) nums[i];
        }
        if (target < down | target > down + diff)
            return;
        Arrays.sort(p);
        float ans = 0;
        int k = target - down;
        int index = p.length - 1;
        for (int i = 0; i < k; i++) {
            ans += 1 - p[index];
            index--;
        }
        while (index >= 0) {
            ans += p[index];
            index--;
        }
        System.out.println(String.format("%.3f", ans));
    }
}
