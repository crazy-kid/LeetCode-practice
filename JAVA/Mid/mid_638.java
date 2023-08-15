package JAVA.Mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class mid_638 {
    static List<Integer> price = new ArrayList<Integer>();
    static List<List<Integer>> special = new ArrayList<List<Integer>>();
    static List<Integer> needs = new ArrayList<Integer>();
    static HashMap<List<Integer>, Integer> memo = new HashMap<List<Integer>, Integer>();
    static int n;

    public static void main(String[] args) {
        price.add(2);
        price.add(3);
        price.add(4);
        List<Integer> tmp = new ArrayList<Integer>();
        tmp.add(1);
        tmp.add(1);
        tmp.add(0);
        tmp.add(4);
        special.add(tmp);
        tmp = new ArrayList<Integer>();
        tmp.add(2);
        tmp.add(2);
        tmp.add(1);
        tmp.add(9);
        special.add(tmp);
        needs.add(1);
        needs.add(2);
        needs.add(1);

        n = price.size();
        System.out.println(dfs(needs));
    }

    public static int dfs(List<Integer> needs) {
        if (memo.containsKey(needs))
            return memo.get(needs);
        int ret = 0;
        for (int i = 0; i < needs.size(); i++)
            ret += needs.get(i) * price.get(i);
        for (List<Integer> spe : special) {
            List<Integer> tmp = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                if (needs.get(j) >= spe.get(j))
                    tmp.add(needs.get(j) - spe.get(j));
            }
            if (tmp.size() == n)
                ret = Math.min(ret, spe.get(n) + dfs(tmp));
        }
        memo.put(needs, ret);
        return ret;
    }
}
