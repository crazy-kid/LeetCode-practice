package JAVA.Hard;

public class hard_42 {

    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

        int n = height.length;
        int[] cursors = { 0, n - 1 };
        int[] max = { height[0], height[n - 1] };
        int ans = 0;
        while (cursors[0] < cursors[1] - 1) {
            int side = max[0] <= max[1] ? 0 : 1;// 0:left 1:right
            cursors[side] += (1 - 2 * side);// left++ or right--
            if (height[cursors[side]] < max[side]) {
                ans += max[side] - height[cursors[side]];
            } else {
                max[side] = height[cursors[side]];
            }
        }
        System.out.println(ans);
    }
}
