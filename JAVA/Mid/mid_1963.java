public class mid_1963 {
    public static void main(String[] args) {
        String s = "][[][[][[][][[]]]]";

        char[] charList = s.toCharArray();
        int[] leftNum = new int[s.length()];
        int[] rightNum = new int[s.length()];
        int ans = 0;
        int cur = charList.length - 1;
        nextCur(cur, charList);

        for (int i = 0; i < charList.length; i++) {
            if (i >= 1) {
                leftNum[i] = leftNum[i - 1];
                rightNum[i] = rightNum[i - 1];
            }
            if (charList[i] == '[')
                leftNum[i]++;
            else
                rightNum[i]++;

            if (leftNum[i] < rightNum[i]) {
                swap(charList, i, cur);
                leftNum[i]++;
                rightNum[i]--;
                ans++;
                cur = nextCur(cur, charList);
                continue;
            }
        }

        System.out.println(ans);

    }

    public static int nextCur(int cur, char[] charList) {
        while (cur >= 0 && charList[cur] != '[')
            cur--;
        return cur;
    }

    public static void swap(char[] charList, int i, int j) {
        char tmp = charList[i];
        charList[i] = charList[j];
        charList[j] = tmp;
    }
}
