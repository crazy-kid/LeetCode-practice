public class easy_944{
    public static void main(String[] args) {
        String[] strs ={"cba","daf","ghi"};

        char[][] chars = new char[strs.length][strs[0].length()];

        for (int i =0;i<strs.length;i++){
            chars[i] = strs[i].toCharArray();
        }

        int ans =0;
        for (int col=0;col<strs[0].length();col++){
            for (int row =0;row<strs.length-1;row++){
                if (chars[row][col]>chars[row+1][col]) {
                    ans++;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}