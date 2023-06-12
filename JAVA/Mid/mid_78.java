package JAVA.Mid;

import java.util.ArrayList;
import java.util.List;

public class mid_78 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        backTrack(list, 0, 0, nums);

        for (List<Integer> l : list) {
            for (int i : l)
                System.out.print(i + " ");
            System.out.println();
        }
    }

    public static void backTrack(List<List<Integer>> list, int first, int len, int[] nums) {
        int n = nums.length;
        if (first == n) {
            List<Integer> l = new ArrayList<Integer>();
            for (int i = 0; i < len; i++) {
                l.add(nums[i]);
            }
            list.add(l);
            return;
        }
        swap(first, len, nums);
        backTrack(list, first + 1, len + 1, nums);// 选择first下标的数字
        swap(first, len, nums);
        backTrack(list, first + 1, len, nums);// 不选择first下标数字
    }

    public static void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
