package JAVA.Mid;

public class mid_424 {

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        int[] count = new int[26];
        char[] slist = s.toCharArray();
        int left = 0;
        int right = 0;
        int max = 0;
        count[slist[0] - 65]++;
        while (left < slist.length) {
            while (right - left + 1 <= maxCount(count) + k) {
                max = Math.max(max, right - left + 1);
                if (++right >= slist.length) {
                    System.out.println(max);
                    return;
                } else
                    count[slist[right] - 65]++;
            }
            count[slist[left++] - 65]--;
        }
        System.out.println(max);
    }

    public static int maxCount(int[] count) {
        int max = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
            }
        }
        return max;
    }
}
