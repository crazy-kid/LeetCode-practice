package JAVA.Mid;

import java.util.ArrayList;
import java.util.HashMap;

public class mid_1442 {

    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 6, 7 };
        HashMap<Integer, ArrayList<Integer>> count = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        tmp.add(0);
        count.put(0, tmp);
        int ans = 0;
        int[] dp = new int[arr.length + 1];
        for (int i = 1; i < arr.length + 1; i++) {
            dp[i] = dp[i - 1] ^ arr[i - 1];
            if (count.containsKey(dp[i])) {
                ArrayList<Integer> list = count.get(dp[i]);
                for (int sub : list) {
                    ans += i - sub - 1;
                }
                list.add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                count.put(dp[i], list);
            }
        }
        System.out.println(ans);
    }
}
