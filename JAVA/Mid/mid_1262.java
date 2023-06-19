package JAVA.Mid;

import java.util.PriorityQueue;

public class mid_1262 {

    public static void main(String[] args) {
        int[] nums = { 3, 6, 5, 1, 8 };

        PriorityQueue<Integer> qMod1 = new PriorityQueue<Integer>();
        PriorityQueue<Integer> qMod2 = new PriorityQueue<Integer>();
        int ans = 0;
        for (int i : nums) {
            ans += i;
            int mod = i % 3;
            switch (mod) {
                case 1:
                    qMod1.add(i);
                    break;
                case 2:
                    qMod2.add(i);
                    break;
                default:
                    break;
            }
        }
        int a = ans, b = ans;
        switch (ans % 3) {
            case 1:
                if (qMod1.size() >= 1)
                    a = qMod1.poll();
                if (qMod2.size() >= 2)
                    b = qMod2.poll() + qMod2.poll();
                ans -= Math.min(a, b);
                break;
            case 2:
                if (qMod1.size() >= 2)
                    a = qMod1.poll() + qMod1.poll();
                if (qMod2.size() >= 1)
                    b = qMod2.poll();
                ans -= Math.min(a, b);
                break;
            default:
                break;
        }
        System.out.println(ans);
    }
}
