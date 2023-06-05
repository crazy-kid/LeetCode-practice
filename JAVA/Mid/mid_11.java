import java.util.Arrays;
import java.util.Stack;

public class mid_11 {

    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

        int n = height.length;
        int[] leftWall = new int[n];
        int[] rightWall = new int[n];
        Arrays.fill(leftWall, -1);
        Arrays.fill(rightWall, -1);
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                leftWall[stack.pop()] = i;
            }
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                rightWall[stack.pop()] = i;
            }
            stack.push(i);
        }

        int left = 0;
        int right = n - 1;
        int max = 0;
        while (left != -1 & right != -1 & left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right])
                left = leftWall[left];
            else if (height[right] < height[left])
                right = rightWall[right];
            else {
                right = rightWall[right];
                left = leftWall[left];
            }
        }

        System.out.println(max);
    }
}
