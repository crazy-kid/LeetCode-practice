package JAVA.Mid;

import java.util.Arrays;

public class mid_1156 {

    public static void main(String[] args) {
        String text = "abcaaa";

        char[] clist = text.toCharArray();
        int n = clist.length;
        int[][] pre = new int[n][2];
        int[][] post = new int[n][2];
        int[] count = new int[26];

        int max = 1;
        for (int i = 0; i < n; i++) {
            count[clist[i] - 97]++;
            pre[i][1] = count[clist[i] - 97];
            if (i >= 1 && clist[i] == clist[i - 1]) {
                pre[i][0] = pre[i - 1][0] + 1;
                max = Math.max(max, pre[i][0] + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (pre[i][0] + 1 < count[clist[i] - 97])
                max = Math.max(max, pre[i][0] + 2);
        }

        Arrays.fill(count, 0);
        for (int i = n - 1; i >= 0; i--) {
            count[clist[i] - 97]++;
            post[i][1] = count[clist[i] - 97];
            if (i <= n - 2 && clist[i] == clist[i + 1]) {
                post[i][0] = post[i + 1][0] + 1;
                max = Math.max(max, post[i][0] + 1);
            }
        }

        for (int i = 1; i < n - 1; i++) {
            if (clist[i - 1] == clist[i + 1] & clist[i] != clist[i - 1]) {
                if (pre[i - 1][0] + 1 < pre[i - 1][1] | post[i + 1][0] + 1 < post[i + 1][1])
                    max = Math.max(max, pre[i - 1][0] + post[i + 1][0] + 3);
                else
                    max = Math.max(max, pre[i - 1][0] + post[i + 1][0] + 2);
            }
        }

        System.out.println(max);
    }
}
