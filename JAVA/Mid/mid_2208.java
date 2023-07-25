package JAVA.Mid;

import java.util.Comparator;
import java.util.PriorityQueue;

public class mid_2208 {

    static int[] nums = { 5, 19, 8, 1 };

    public static void main(String[] args) {
        long sum = 0;
        PriorityQueue<Double> queue = new PriorityQueue<Double>(new Comparator<Double>() {
            @Override
            public int compare(Double a, Double b) {
                if (a > b)
                    return -1;
                if (b > a)
                    return 1;
                return 0;
            }
        });
        for (int num : nums) {
            sum += num;
            queue.add((double) num);
        }
        double target = (double) sum / 2;
        int ans = 0;
        while (target > 0) {
            double tmp = queue.poll();
            target -= tmp / 2;
            queue.add(tmp / 2);
            ans++;
        }
        System.out.println(ans);
    }
}
