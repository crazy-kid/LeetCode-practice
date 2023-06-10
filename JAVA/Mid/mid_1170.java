import java.util.Arrays;

public class mid_1170 {

    public static void main(String[] args) {
        String[] queries = { "aabbabbb", "abbbabaa", "aabbbabaa", "aabba", "abb", "a", "ba", "aa", "ba", "baabbbaaaa",
                "babaa", "bbbbabaa" };
        String[] words = { "b", "aaaba", "aaaabba", "aa", "aabaabab", "aabbaaabbb", "ababb", "bbb", "aabbbabb", "aab",
                "bbaaababba", "baaaaa" };

        int[] fq = new int[queries.length];
        int[] fw = new int[words.length];
        for (int i = 0; i < fq.length; i++) {
            fq[i] = func(queries[i]);
        }
        for (int i = 0; i < fw.length; i++) {
            fw[i] = func(words[i]);
        }
        int[] ans = new int[fq.length];
        Arrays.sort(fw);
        for (int i = 0; i < ans.length; i++) {
            int left = 0;
            int right = fw.length - 1;
            if (fq[i] >= fw[right]) {
                ans[i] = 0;
                continue;
            }
            while (left < right) {
                int mid = (left + right) / 2;
                if (fw[mid] <= fq[i])
                    left = mid + 1;
                else
                    right = mid;
            }
            ans[i] = fw.length - left;
        }

        for (int i : ans)
            System.out.print(i + " ");
    }

    public static int func(String str) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 97]++;
        }
        for (int i : count) {
            if (i > 0)
                return i;
        }
        return 0;
    }
}
