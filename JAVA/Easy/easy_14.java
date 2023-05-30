public class easy_14 {

    public static void main(String[] args) {
        String[] str = { "flower", "flow", "flight" };

        StringBuilder ans = new StringBuilder();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < str.length; i++) {
            min = Math.min(str[i].length(), min);
        }

        for (int i = 0; i < min; i++) {
            for (int j = 1; j < str.length; j++) {
                if (str[j].charAt(i) != str[j - 1].charAt(i)) {
                    System.out.println(ans);
                    return;
                }
            }
            ans.append(str[0].charAt(i));
        }

    }
}
