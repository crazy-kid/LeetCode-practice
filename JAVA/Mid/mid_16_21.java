package JAVA.Mid;

import java.util.Arrays;

public class mid_16_21 {

    public static void main(String[] args) {
        int[] array1 = { 4, 1, 2, 1, 1, 2 };
        int[] array2 = { 3, 6, 3, 3 };

        Arrays.sort(array1);
        Arrays.sort(array2);

        int sum1 = 0;
        int sum2 = 0;
        for (int i : array1)
            sum1 += i;
        for (int i : array2)
            sum2 += i;
        int diff = sum1 - sum2;
        if (diff % 2 != 0)
            return;
        diff = diff / 2;
        for (int i = 0; i < array1.length; i++) {// 遍历arry1中所有的数
            int left = 0;
            int right = array2.length - 1;
            if (array1[i] - diff < array2[left] | array1[i] - diff > array2[right])// 预筛选
                continue;
            int mid = (left + right) / 2;
            while (left < right) {
                mid = (left + right) / 2;
                if (array1[i] - diff == array2[mid])
                    return;
                if (mid == left) {
                    if (array1[i] - diff == array2[right])
                        return;
                    else
                        break;
                }
                if (array1[i] - diff > array2[mid]) {
                    left = mid;
                } else
                    right = mid;
            }
        }
        return;
    }
}
