package JAVA.Hard;

public class hard_600 {

    public static void main(String[] args) {
        int n = 5;
        int len = Integer.toBinaryString(n).length();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = n % 2;
            n /= 2;
        }
        int[] end1 = new int[len];
        int[] end0 = new int[len];
        end1[0] = 1;
        end0[0] = 1;
        for (int i = 1; i < len; i++) {
            end1[i] = end0[i - 1];
            end0[i] = end1[i - 1] + end0[i - 1];
        }

        int ans = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (i + 1 < len && (nums[i] & nums[i + 1]) == 1) {
                ans += end0[i];
                break;
            }
            if (i == 0) {
                ans += nums[i] + 1;
                break;
            }
            if (nums[i] == 1)
                ans += end0[i];
        }
        System.out.println(ans);
    }
}
