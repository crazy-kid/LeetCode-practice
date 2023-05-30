public class mid_221 {

    public static void main(String[] args) {
        // char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
        // { '1', '1', '1', '1', '1' },
        // { '1', '0', '0', '1', '0' } };

        char[][] matrix = { { '1' } };
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] preSum = new int[m + 1][n + 1];
        for (int row = 1; row < m + 1; row++)
            for (int col = 1; col < n + 1; col++)
                preSum[row][col] = matrix[row - 1][col - 1] - 48 + preSum[row][col - 1] + preSum[row - 1][col]
                        - preSum[row - 1][col - 1];

        int left = 0;
        int right = Math.min(n, m);
        while (left < right) {
            int mid = (left + right) / 2;
            if (isPossible(preSum, mid - 1)) {
                if (left == mid) {
                    if (isPossible(preSum, right - 1))
                        left = right;
                    break;
                }
                left = mid;
            } else {
                right = mid;
            }
        }
        System.out.println(left * left);
    }

    public static boolean isPossible(int[][] preSum, int l) {
        if (l < 0)
            return true;
        int m = preSum.length;
        int n = preSum[0].length;
        for (int left = 1; left + l < n; left++) {
            for (int up = 1; up + l < m; up++) {
                int right = left + l;
                int down = up + l;
                if (preSum[down][right] + preSum[up - 1][left - 1] - preSum[up - 1][right]
                        - preSum[down][left - 1] == (l + 1) * (l + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}