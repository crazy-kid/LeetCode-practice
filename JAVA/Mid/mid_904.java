package JAVA.Mid;

public class mid_904 {

    public static void main(String[] args) {
        int[] fruits = { 1, 2, 3, 2, 2 };
        int k = 2;

        int n = fruits.length;
        int[] count = new int[n];
        int size = 0, left = 0, right = -1, max = 0;
        while (++right < n) {
            if (count[fruits[right]]++ == 0) {
                size++;
            }
            while (size > k) {
                if (--count[fruits[left++]] == 0)
                    size--;
            }
            max = Math.max(max, right - left + 1);
        }
        System.out.println(max);
    }
}
