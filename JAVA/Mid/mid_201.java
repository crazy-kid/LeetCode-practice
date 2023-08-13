package JAVA.Mid;

public class mid_201 {
    static int left = 6, right = 12;

    public static void main(String[] args) {
        int ans = right;
        for (int i = 0; i < 32; i++) {
            if ((right & ~(1 << i)) >= left) {
                ans &= ~(1 << i);
            }
        }
        ans &= left;
        System.out.println(ans);
    }
}