public class mid_2116 {
    public static void main(String[] args) {
        String s = "())(()(()(())()())(())((())(()())((())))))(((((((())(()))))(";
        String locked = "100011110110011011010111100111011101111110000101001101001111";

        char[] lockedList = locked.toCharArray();
        char[] sList = s.toCharArray();
        int n = sList.length;
        int[] leftNum = new int[n];
        int[] rightNum = new int[n];

        if (sList[0] == '0' & lockedList[0] == '1')
            return;
        leftNum[0] = 1;
        int cur = 1;
        cur = nextCur(sList, lockedList, cur);
        for (int i = 1; i < n; i++) {
            leftNum[i] = leftNum[i - 1];
            rightNum[i] = rightNum[i - 1];
            if (sList[i] == '(')
                leftNum[i]++;
            else {
                rightNum[i]++;
                if (rightNum[i] > leftNum[i]) {
                    if (cur > i)
                        return;
                    else {
                        rightNum[i]--;
                        leftNum[i]++;
                        cur = nextCur(sList, lockedList, cur);
                    }
                }
            }
        }
        int leftcur = 0;
        while (rightNum[n - 1] != leftNum[n - 1]) {
            while (leftcur < n && (sList[leftcur] == ')' | lockedList[leftcur] == '1')) {
                leftcur++;
            }
            if (leftcur < n) {
                rightNum[n - 1]++;
                leftNum[n - 1]--;
            } else
                return;
        }
    }

    public static int nextCur(char[] sList, char[] lockedList, int cur) {
        int n = sList.length;
        while (cur < n && (sList[cur] == '(' | lockedList[cur] == '1')) {
            cur++;
        }
        return cur;
    }
}
