package JAVA.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class hard_1345 {

    public static void main(String[] args) {
        int[] arr = { 7, 7, 2, 1, 7, 7, 7, 3, 4, 1 };

        int n = arr.length;
        int[] step = new int[n];
        Arrays.fill(step, -1);
        step[0] = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            List<Integer> tmp = map.getOrDefault(arr[i], new ArrayList<Integer>());
            tmp.add(i);
            map.put(arr[i], tmp);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            if (index == n - 1) {
                System.out.println(step[index]);
                return;
            }
            if (index - 1 >= 0 && step[index - 1] < 0) {
                step[index - 1] = step[index] + 1;
                queue.add(index - 1);
            }
            if (index + 1 < n && step[index + 1] < 0) {
                step[index + 1] = step[index] + 1;
                queue.add(index + 1);
            }
            if (map.containsKey(arr[index]))
                for (int i : map.get(arr[index]))
                    if (step[i] < 0) {
                        step[i] = step[index] + 1;
                        queue.add(i);
                    }
            map.remove(arr[index]);
        }
    }
}
