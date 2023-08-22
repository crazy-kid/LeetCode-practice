package JAVA.Mid;

public class mid_849 {

    public static void main(String[] args) {
        int[] seats = { 1, 0, 0, 0 };

        int ans = 0, slow = 0, fast;
        while (slow < seats.length) {
            if (seats[slow] == 1)
                break;
            slow++;
        }
        ans = slow;
        fast = slow + 1;
        while (fast < seats.length) {
            if (seats[fast] == 1) {
                ans = Math.max(ans, (fast - slow) / 2);
                slow = fast;
            }
            fast++;
        }
        ans = Math.max(ans, fast - slow - 1);
        System.out.println(ans);
    }
}
