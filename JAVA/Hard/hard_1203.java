package JAVA.Hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class hard_1203 {
    static int n = 8, m = 2;
    static int[] group = { -1, -1, 1, 0, 0, 1, 0, -1 };
    static List<List<Integer>> beforeItems = new ArrayList<List<Integer>>();

    static HashSet<Integer>[] degreeIn = new HashSet[n];
    static HashSet<Integer>[] degreeOut = new HashSet[n];
    static HashSet<Integer>[] groupIn, groupOut;
    static List<Integer>[] groupAns;

    public static void main(String[] args) {
        int[][] list = { {}, { 6 }, { 5 }, { 6 }, { 3, 6 }, {}, {}, {} };
        initBeforeItems(list);

        // statistic and modifiy group
        int sizeCommon = 0;
        for (int i = 0; i < n; i++)
            if (group[i] == -1) {
                sizeCommon++;
                group[i] = m - 1 + sizeCommon;
            }

        groupIn = new HashSet[m + sizeCommon];
        groupOut = new HashSet[m + sizeCommon];
        groupAns = new ArrayList[m + sizeCommon];
        for (int i = 0; i < m + sizeCommon; i++) {
            groupIn[i] = new HashSet<Integer>();
            groupOut[i] = new HashSet<Integer>();
            groupAns[i] = new ArrayList<Integer>();
        }

        // build graph and group_graph
        for (int i = 0; i < n; i++) {
            degreeOut[i] = new HashSet<Integer>();
            degreeIn[i] = new HashSet<Integer>();
        }
        for (int i = 0; i < n; i++) {
            for (int pa : beforeItems.get(i)) {
                degreeIn[i].add(pa);
                degreeOut[pa].add(i);
                if (group[i] != group[pa]) {
                    groupIn[group[i]].add(group[pa]);
                    groupOut[group[pa]].add(group[i]);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < n; i++)
            if (degreeIn[i].size() == 0)
                queue.add(i);
        while (!queue.isEmpty()) {
            int pa = queue.poll();
            groupAns[group[pa]].add(pa);
            for (int child : degreeOut[pa]) {// node-->child
                degreeIn[child].remove(pa);
                if (degreeIn[child].size() == 0)
                    queue.add(child);
            }
            degreeOut[pa].clear();
        }

        List<Integer> ans = new ArrayList<Integer>();
        queue.clear();
        for (int i = 0; i < m + sizeCommon; i++)
            if (groupIn[i].size() == 0)
                queue.add(i);
        while (!queue.isEmpty()) {
            int pa = queue.poll();
            ans.addAll(groupAns[pa]);
            for (int child : groupOut[pa]) {
                groupIn[child].remove(pa);
                if (groupIn[child].size() == 0)
                    queue.add(child);
            }
            groupOut[pa].clear();
        }

        // if (ans.size() != n) {
        // System.out.println(false);
        // return;
        // }
        for (int i : ans)
            System.out.print(i + " ");
    }

    public static void initBeforeItems(int[][] list) {
        for (int[] i : list) {
            List<Integer> tmp = new ArrayList<Integer>();
            for (int j : i)
                tmp.add(j);
            beforeItems.add(tmp);
        }
    }
}