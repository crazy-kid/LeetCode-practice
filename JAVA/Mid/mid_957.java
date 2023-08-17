package JAVA.Mid;

import java.util.Arrays;

public class mid_957 {

    static final int bits = 6;

    public static void main(String[] args) {
        int[] cells = { 0, 1, 0, 1, 1, 0, 0, 1 };
        int n = 7;

        int[] next = new int[1 << bits];
        int dayOne = 0;// 8 bit
        for (int i = 1; i <= bits; i++) {
            if ((cells[i - 1] == 0 & cells[i + 1] == 0) || (cells[i - 1] == 1 & cells[i + 1] == 1))
                dayOne += 1;
            dayOne <<= 1;
        }

        // System.out.println(Integer.toBinaryString(nextDay(82)));
        for (int i = 0; i < (1 << bits); i++) {
            next[i] = nextDay(i << 1) >> 1;
        }

        boolean[] visited = new boolean[64];
        int cur = nextDay(dayOne) >> 1;// 6bit

        while (!visited[cur]) {
            // System.out.println(Integer.toBinaryString(cur));
            visited[cur] = true;
            cur = next[cur];
        }

        Arrays.fill(visited, false);
        int per = 0;
        while (!visited[cur]) {
            // System.out.println(Integer.toBinaryString(cur));
            visited[cur] = true;
            cur = next[cur];
            per++;
        }
        // System.out.println(per);

        n--;
        cur = dayOne >> 1;
        while (n > 0) {
            if (visited[cur]) {
                n %= per;
                break;
            }
            cur = next[cur];
            n--;
        }

        while (n > 0) {
            cur = next[cur];
            n--;
        }

        int[] ans = new int[bits + 2];
        for (int i = 0; i < bits; i++) {
            ans[bits - i] = ((cur >> i) & 1);
        }
        System.out.println(Integer.toBinaryString(cur));
    }

    public static int nextDay(int today) {// 8bit->8bit
        int ret = 0;
        for (int i = 1; i <= bits; i++) {
            int right = (today >> (i - 1)) & 1;
            int left = (today >> (i + 1)) & 1;
            if ((right ^ left) == 0) {
                ret += (1 << i);
            }
        }
        // System.out.println(Integer.toBinaryString(today) + " -> " +
        // Integer.toBinaryString(ret));
        return ret;
    }
}
