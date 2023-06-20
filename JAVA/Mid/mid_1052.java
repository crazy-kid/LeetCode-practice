package JAVA.Mid;

public class mid_1052 {

    public static void main(String[] args) {
        int[] customers = { 1, 0, 1, 2, 1, 1, 7, 5 };
        int[] grumpy = { 0, 1, 0, 1, 0, 1, 0, 1 };
        int minutes = 3;

        int sum = 0;
        int win = 0;
        for (int i = 0; i < minutes; i++) {
            sum += customers[i] * (1 - grumpy[i]);
            if (grumpy[i] == 1)
                win += customers[i];
        }
        int max = win;
        for (int i = minutes; i < customers.length; i++) {
            sum += customers[i] * (1 - grumpy[i]);
            win += customers[i] * grumpy[i];
            win -= customers[i - minutes] * grumpy[i - minutes];
            max = Math.max(max, win);
        }
        System.out.println(sum + max);
    }
}
