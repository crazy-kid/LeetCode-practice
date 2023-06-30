package JAVA.Mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class mid_1299 {

    public static void main(String[] args) {
        int[][] slots1 = { { 216397070, 363167701 }, { 98730764, 158208909 }, { 441003187, 466254040 },
                { 558239978, 678368334 }, { 683942980, 717766451 } };
        int[][] slots2 = { { 50490609, 222653186 }, { 512711631, 670791418 }, { 730229023, 802410205 },
                { 812553104, 891266775 }, { 230032010, 399152578 } };
        int duration = 456085;

        Comparator<int[]> myComparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        };
        Arrays.sort(slots1, myComparator);
        Arrays.sort(slots2, myComparator);

        List<Integer> ans = new ArrayList<Integer>();
        int cur1 = 0, cur2 = 0;
        while (cur1 < slots1.length & cur2 < slots2.length) {
            int b = Math.min(slots1[cur1][1], slots2[cur2][1]);
            int a = Math.max(slots1[cur1][0], slots2[cur2][0]);
            if (Math.min(slots1[cur1][1], slots2[cur2][1]) - Math.max(slots1[cur1][0], slots2[cur2][0]) >= duration) {
                ans.add(Math.max(slots1[cur1][0], slots2[cur2][0]));
                ans.add(Math.max(slots1[cur1][0], slots2[cur2][0]) + duration);
                break;
            } else {
                if (slots1[cur1][1] < slots2[cur2][1])
                    cur1++;
                else
                    cur2++;
            }
        }
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
