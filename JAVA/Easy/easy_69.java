public class easy_69 {

    public static void main(String[] args) {
        int x = 2147483647;
        int left = 0;
        int right = x;
        while (left < right) {
            long mid = ((long) left + right + 1) / 2;
            if (mid * mid > x)
                right = (int) mid - 1;
            else
                left = (int) mid;
        }
        System.out.println(left);
    }
}
