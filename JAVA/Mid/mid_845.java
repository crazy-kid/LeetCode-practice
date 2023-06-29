package JAVA.Mid;

public class mid_845 {

    public static void main(String[] args) {
        int[] arr = { 2, 1, 4, 7, 3, 2, 5 };

        int left = -1, right, state = 0, ans = 0;
        for (right = 1; right < arr.length; right++) {
            if (arr[right] > arr[right - 1]) {
                if (state != 1)
                    left = right - 1;
                state = 1;
            } else if (arr[right] < arr[right - 1]) {
                if (left != -1) {
                    ans = Math.max(right - left + 1, ans);
                }
                state = -1;
            } else {
                left = -1;
                state = 0;
            }
        }
        System.out.println(ans);
    }
}
