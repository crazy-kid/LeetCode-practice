import java.util.HashSet;

public class mid_1525 {
    public static void main(String[] args) {
        String s = "aacaba";

        char[] charList = s.toCharArray();
        int[] p = new int[s.length()];
        int[] q = new int[s.length()];

        HashSet<Character> pSet = new HashSet<Character>();
        HashSet<Character> qSet = new HashSet<Character>();

        for (int i = 0; i < charList.length; i++) {
            pSet.add(charList[i]);
            p[i] = pSet.size();
        }

        for (int i = charList.length - 1; i >= 0; i--) {
            qSet.add(charList[i]);
            q[i] = qSet.size();
        }

        int ans = 0;
        for (int i = 0; i < charList.length - 1; i++) {
            if (p[i] == q[i + 1])
                ans++;
        }
        System.out.println(ans);
    }
}
