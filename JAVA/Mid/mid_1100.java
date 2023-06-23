package JAVA.Mid;

public class mid_1100 {

    public static void main(String[] args) {
        String s = "havefunonleetcode";
        int k = 5;

        char[] slist = s.toCharArray();
        if (k > 26 | k > s.length())
            return;
        boolean[] set = new boolean[26];
        int left = 0, right = -1, ans = 0, size = 0;
        while (right + 1 < slist.length) {
            right++;
            size++;
            if (set[slist[right] - 'a']) {
                while (slist[left] != slist[right]) {
                    set[slist[left] - 'a'] = false;
                    left++;
                    size--;
                }
                left++;
                size--;
            } else
                set[slist[right] - 'a'] = true;
            if (size >= k) {
                ans++;
                System.out.println(s.substring(left, right + 1));
            }
        }
        System.out.println(ans);
    }
}
