package JAVA.Mid;

public class mid_1358 {

    public static void main(String[] args) {
        String s = "abcabc";

        char[] slist = s.toCharArray();
        System.out.println(lessThan(slist, 4));
        System.out.println(lessThan(slist, 3));
    }

    public static int lessThan(char[] slist, int k) {
        int[] count = new int[3];
        int left = 0, right = -1, ret = 0, size = 0;
        while (++right < slist.length) {
            if (count[slist[right] - 'a']++ == 0) {
                size++;
            }
            while (size >= k) {
                if (--count[slist[left++] - 'a'] == 0)
                    size--;
            }
            ret += right - left + 1;
        }
        return ret;
    }
}
