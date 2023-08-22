package JAVA.Mid;

import java.util.HashMap;

public class mid_454 {
    public static void main(String[] args) {
        int[] num1 = { 1, 2 };
        int[] num2 = { -2, -1 };
        int[] num3 = { -1, 2 };
        int[] num4 = { 0, 2 };

        int n = num1.length, ans = 0;
        HashMap<Integer, Integer> count1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> count2 = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = num1[i] + num2[j];
                count1.put(tmp, count1.getOrDefault(tmp, 0) + 1);
                tmp = num3[i] + num4[j];
                count2.put(tmp, count2.getOrDefault(tmp, 0) + 1);
            }
        }
        for (int key : count1.keySet()) {
            if (count2.containsKey(-key)) {
                ans += count1.get(key) * count2.get(-key);
            }
        }
        System.out.println(ans);
    }
}
