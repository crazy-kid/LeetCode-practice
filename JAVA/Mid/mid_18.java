package JAVA.Mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mid_18 {

    public static void main(String[] args) {
        int[] nums = { 2, 2, 2, 2 };
        int target = 8;

        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (n < 4)
            return;
        for (int first = 0; first < n - 3; first++) {
            if (first > 0 && nums[first] == nums[first - 1])
                continue;
            for (int second = first + 1; second < n - 2; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1])
                    continue;
                int third = second + 1, forth = n - 1;
                while (third < forth) {
                    if ((long) nums[first] + (long) nums[second] + (long) nums[third]
                            + (long) nums[forth] == (long) target) {
                        int[] array = { nums[first], nums[second], nums[third], nums[forth] };
                        List<Integer> tmp = new ArrayList<Integer>();
                        for (int i : array)
                            tmp.add(i);
                        ans.add(tmp);
                        while (third + 1 < forth && nums[third + 1] == nums[third])
                            third++;
                        while (forth - 1 > third && nums[forth - 1] == nums[forth])
                            forth--;
                        third++;
                        forth--;
                    } else if ((long) nums[first] + (long) nums[second] + (long) nums[third]
                            + (long) nums[forth] < (long) target)
                        third++;
                    else
                        forth--;
                }
            }
        }
        for (List<Integer> l : ans) {
            System.out.println();
            for (int i : l) {
                System.out.print(i + " ");
            }
        }
    }
}
