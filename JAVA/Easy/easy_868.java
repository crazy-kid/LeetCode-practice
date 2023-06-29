package JAVA.Easy;

public class easy_868 {

    public static void main(String[] args) {
        int n = 22;
        int max = 0;
        int cur = 1;
        while (n != 0) {
            if (n % 2 == 1) {
                n = n >> 1;
                break;
            }
            n = n >> 1;
        }
        while (n != 0) {
            if (n % 2 == 1) {
                max = Math.max(max, cur);
                cur = 1;
            } else {
                cur++;
            }
            n = n >> 1;
        }
        System.out.println(max);
    }
}
