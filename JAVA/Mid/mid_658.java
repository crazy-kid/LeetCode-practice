package JAVA.Mid;

public class mid_658 {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int k = 4;
        int x = -1;

        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > x)
                right = mid;
            else
                left = mid;
            if (right - left <= 1)
                break;
        }
        while (right - left + 1 < k + 2) {
            if (left >= 0 && (right == arr.length || Math.abs(x - arr[left]) <= Math.abs(arr[right] - x))) {
                left--;
                continue;
            }
            if (right < arr.length && (left == -1 || Math.abs(arr[right] - x) <= Math.abs(x - arr[left]))) {
                right++;
                continue;
            }
        }

        for (int i = left + 1; i < right; i++)
            System.out.print(i + " ");
    }
}
