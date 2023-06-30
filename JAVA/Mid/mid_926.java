package JAVA.Mid;

public class mid_926 {

    public static void main(String[] args) {
        String s = "00011000";

        char[] list = s.toCharArray();
        int sum = 0, postSum = 0, ans = list.length;
        for (char c : list)
            if (c == '1')
                sum += 1;
        ans = Math.min(sum, list.length - sum);// 全都是0或者1
        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i] == '1')
                postSum += 1;
            ans = Math.min(ans, list.length - i - postSum + sum - postSum);
        }
        System.out.println(ans);
    }
}
