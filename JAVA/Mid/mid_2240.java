package JAVA.Mid;

public class mid_2240 {

    public static void main(String[] args) {
        int total = 100;
        int cost1 = 1;
        int cost2 = 1;

        int ans = 0;
        int left = total + cost1;
        for (int i = 0; i <= total / cost1; i++) {
            left -= cost1;
            ans += (left / cost2) + 1;
        }
        System.out.println(ans);
    }
}
