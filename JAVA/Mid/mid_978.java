package JAVA.Mid;

public class mid_978 {

    public static void main(String[] args) {
        int[] arr = { 9, 4, 2, 10, 7, 8, 8, 1, 9 };

        if (arr.length == 1)
            return;
        int max = 1, left = 0, right = 0;
        while (right + 1 < arr.length) {
            if (left == right) {
                if (arr[right + 1] == arr[right]) {
                    left++;
                }
                right++;
            } else {
                if ((arr[right] - arr[right - 1]) * (arr[right] - arr[right + 1]) <= 0)
                    left = right;
                else
                    right++;
            }
            if (right < arr.length)
                max = Math.max(max, right - left + 1);
        }
        System.out.println(max);
    }
}
