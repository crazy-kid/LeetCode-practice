public class easy_2103 {

    public static void main(String[] args) {
        String rings = "B0B6G0R6R0R6G9";

        char[] cList = rings.toCharArray();
        int[][] count = new int[10][3];

        for (int i = 0; i < cList.length; i = i + 2) {
            int num = cList[i + 1] - 48;
            switch (cList[i]) {
                case 'R':
                    count[num][0] = 1;
                    break;
                case 'G':
                    count[num][1] = 1;
                    break;
                case 'B':
                    count[num][2] = 1;
                    break;
                default:
                    System.out.println("Error");
            }
        }
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            if (count[i][0] == 1 & count[i][1] == 1 & count[i][2] == 1) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
