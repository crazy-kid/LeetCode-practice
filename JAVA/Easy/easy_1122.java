package JAVA.Easy;

import java.util.Arrays;
import java.util.HashMap;

public class easy_1122 {

    public static void main(String[] args) {
        int[] arr1 = { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 };
        int[] arr2 = { 2, 1, 4, 3, 9, 6 };

        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int i : arr1)
            count.put(i, count.getOrDefault(i, 0) + 1);
        int cur = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < count.get(arr2[i]); j++)
                arr1[cur++] = arr2[i];
            count.remove(arr2[i]);
        }
        int tail = cur;
        for (int key : count.keySet()) {
            for (int i = 0; i < count.get(key); i++) {
                arr1[cur++] = key;
            }
        }
        Arrays.sort(arr1, tail, arr1.length);
        for (int i : arr1)
            System.out.print(i + " ");
    }
}
