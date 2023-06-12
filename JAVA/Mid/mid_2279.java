package JAVA.Mid;

import java.util.Arrays;

public class mid_2279 {

    public static void main(String[] args) {
        int[] capacity = { 10, 2, 2 };
        int[] rocks = { 2, 2, 0 };
        int additionalRocks = 100;

        int[] space = new int[capacity.length];
        for (int i = 0; i < space.length; i++) {
            space[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(space);
        int ans = 0;
        int index = 0;
        while (space[index] == 0) {
            ans++;
            index++;
        }
        while (additionalRocks >= 0 & index < space.length) {
            additionalRocks -= space[index];
            ans++;
            index++;
        }
        if (additionalRocks < 0)
            ans--;
        System.out.println(ans);
    }
}
