public class mid_1423 {
    public static void main(String[] args) {
        int[] cards = { 1, 2, 3, 4, 5, 6, 1 };
        int k = 3;

        int sum = 0;
        for (int i : cards)
            sum += i;
        if (k >= cards.length)
            return;

        int rest = cards.length - k;
        int min = 0;
        for (int i = 0; i < rest; i++) {
            min += cards[i];
        }
        int tmp = min;
        for (int i = rest; i < cards.length; i++) {
            tmp += cards[i];
            tmp -= cards[i - rest];
            min = Math.min(tmp, min);
        }
        System.out.println(sum - min);
    }
}
