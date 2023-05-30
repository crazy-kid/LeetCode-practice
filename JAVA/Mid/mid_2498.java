public class mid_2498 {

    public static void main(String[] args) {
        int[] stones = { 0, 2, 5, 6, 7 };

        if (stones.length == 2)
            return;
        int ans = stones[2] - stones[0];
        for (int i = 3; i < stones.length; i++) {
            ans = Math.max(ans, stones[i] - stones[i - 1]);
        }
        System.out.println(ans);
    }
}
