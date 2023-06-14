package JAVA.Hard;

import java.util.TreeMap;

public class hard_220 {

    public static void main(String[] args) {
        int[] nums = { -3, 3 };
        int indexDiff = 2;
        int valueDiff = 8;

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int cur;
        for (cur = 0; cur <= indexDiff & cur < nums.length; cur++) {
            if (add2map(map, nums[cur], valueDiff))
                return;
        } // end with cur==indexDiff+1

        while (cur < nums.length) {
            // delete left num
            int del = nums[cur - indexDiff - 1];
            int count = map.get(del);
            if (count == 1)
                map.remove(del);
            else
                map.put(del, count - 1);
            if (add2map(map, nums[cur], valueDiff))
                return;
            cur++;
        }
        System.out.println(false);
    }

    public static boolean add2map(TreeMap<Integer, Integer> map, int key, int valueDiff) {
        int count = map.getOrDefault(key, 0);
        Integer nearKey;
        if (count > 0)
            return true;
        else {
            nearKey = map.higherKey(key);
            if (nearKey != null && nearKey - key <= valueDiff)
                return true;
            nearKey = map.lowerKey(key);
            if (nearKey != null && key - nearKey <= valueDiff)
                return true;
        }
        map.put(key, count + 1);
        return false;
    }
}
