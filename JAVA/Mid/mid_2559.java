public class mid_2559 {

    public static void main(String[] args) {
        String[] words = { "aba", "bcb", "ece", "aa", "e" };
        int[][] queries = { { 0, 2 }, { 1, 4 }, { 1, 1 } };

        int[] pre = new int[words.length + 1];
        for (int i = 0; i < words.length; i++) {
            pre[i + 1] = pre[i];
            char b = words[i].charAt(0);
            char e = words[i].charAt(words[i].length() - 1);
            if (isVowels(b) & isVowels(e))
                pre[i + 1]++;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = pre[queries[i][1] + 1] - pre[queries[i][0]];
            System.out.print(ans[i] + " ");
        }
    }

    public static boolean isVowels(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }
}
