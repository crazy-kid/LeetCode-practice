package JAVA.Easy;

import java.util.ArrayList;
import java.util.Arrays;

public class easy_2475 {
    public static void main(String[] args) {
        int[] nums = { 4, 4, 2, 4, 3 };
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> count = new ArrayList<ArrayList<Integer>>();

        int curNum = nums[0];
        int curCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curNum == nums[i])
                curCount++;
            else {
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                tmp.add(curNum);
                tmp.add(curCount);
                count.add(tmp);
                curNum = nums[i];
                curCount = 1;
            }
        }
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        tmp.add(curNum);
        tmp.add(curCount);
        count.add(tmp);

        if (count.size() <= 2)
            return;

        int ans = 0;
        int mulF = count.get(0).get(1);

        int mulT = 0;
        for (int i = 2; i < count.size(); i++) {
            mulT = mulT + count.get(i).get(1);
        }

        for (int i = 1; i < count.size() - 1; i++) {
            ans = ans + count.get(i).get(1) * mulF * mulT;
            mulF = mulF + count.get(i).get(1);
            mulT = mulT - count.get(i + 1).get(1);
        }

        System.out.println(ans);
    }
}
