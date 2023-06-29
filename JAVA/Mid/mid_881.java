package JAVA.Mid;

import java.util.Arrays;

public class mid_881 {

    public static void main(String[] args) {
        int[] people = { 3, 2, 2, 1 };
        int limit = 3;

        Arrays.sort(people);
        int left = 0, right = people.length - 1, ans = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
            ans++;
        }
        System.out.println(ans);
    }
}
