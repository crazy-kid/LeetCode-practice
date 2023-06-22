package JAVA.Hard;

public class hard_995 {

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0 };
        int k = 1;

        int ans = 0;
        int[] diff = new int[nums.length + 1];
        int curFlip = 0;
        for (int i = 0; i < nums.length; i++) {
            curFlip += diff[i];
            if ((nums[i] + curFlip) % 2 == 0) {
                diff[i]++;
                curFlip++;
                if (i + k > nums.length)
                    return;
                diff[i + k]--;
                ans++;
            }
        }
        System.out.println(ans);
    }
}
