package JAVA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class test {

    public static void main(String[] args) {
        System.out.println("null");

        int[] nums = { 1, 2, 3, 4 };
        List<Integer> list = new ArrayList<>();
        list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int i : list)
            System.out.println(i);
        System.out.println(nums[3]);
    }
}
