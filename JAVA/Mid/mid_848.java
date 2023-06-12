package JAVA.Mid;

public class mid_848 {

    public static void main(String[] args) {
        String s = "abc";
        int[] shifts = { 3, 5, 9 };

        char[] clist = s.toCharArray();
        int[] postSum = new int[shifts.length];
        int tmp = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            tmp += shifts[i];
            tmp = tmp % 26;
            postSum[i] = tmp;
        }
        for (int i = 0; i < clist.length; i++) {
            clist[i] = (char) ((clist[i] - 97 + postSum[i]) % 26 + 97);
        }
        StringBuilder ans = new StringBuilder();
        for (char c : clist) {
            ans.append(c);
        }
        System.out.println(ans.toString());
    }
}
