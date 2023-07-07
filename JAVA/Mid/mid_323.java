package JAVA.Mid;

import java.util.HashSet;

public class mid_323 {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 3, 4 } };

        int[] pa = new int[n];
        for (int i = 0; i < n; i++)
            pa[i] = i;
        for (int[] edge : edges) {
            merge(pa, edge[0], edge[1]);
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            find(pa, i);
            set.add(pa[i]);
        }
        System.out.println(set.size());
    }

    public static int find(int[] pa, int x) {
        return pa[x] = x == pa[x] ? x : find(pa, pa[x]);
    }

    public static void merge(int[] pa, int x, int y) {
        int pax = find(pa, x);
        int pay = find(pa, y);
        if (pax < pay)
            pa[pay] = pax;
        else
            pa[pax] = pay;
        find(pa, x);
        find(pa, y);
    }

}
