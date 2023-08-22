package JAVA.Mid;

import java.util.HashMap;

public class mid_128 {

    static HashMap<Integer, Integer> root = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };

        for (int i : nums) {
            if (!root.containsKey(i)) {
                root.put(i, i);
                if (root.containsKey(i - 1))
                    merge(i, i - 1);
                if (root.containsKey(i + 1))
                    merge(i, i + 1);
            }
        }
        for (int key : root.keySet()) {
            find(key);
        }
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int key : root.keySet()) {
            int r = root.get(key);
            count.put(r, count.getOrDefault(r, 0) + 1);
        }
        int ans = 0;
        for (int key : count.keySet()) {
            ans = Math.max(ans, count.get(key));
        }
        System.out.println(ans);
    }

    public static int find(int x) {
        if (!root.containsKey(x)) {
            System.out.println("invalid key");
            return 0;
        }
        if (root.get(x) == x)
            return x;
        else {
            int r = find(root.get(x));
            root.put(x, r);
            return r;
        }
    }

    public static void merge(int x, int y) {
        int pax = find(x);
        int pay = find(y);
        if (pax <= pay) {
            root.put(pay, pax);
            find(y);
        } else {
            root.put(pax, pay);
            find(x);
        }
    }
}
