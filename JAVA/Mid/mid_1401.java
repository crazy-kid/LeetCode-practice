package JAVA.Mid;

public class mid_1401 {

    public static void main(String[] args) {
        int radius = 1, xCenter = 0, yCenter = 0;
        int x1 = 1, y1 = -1, x2 = 3, y2 = 1;

        int[][] corners = { { x1, y1 }, { x1, y2 }, { x2, y1 }, { x2, y2 } };

        if (x1 <= xCenter - radius & x2 >= xCenter + radius & y1 <= yCenter - radius & y2 >= yCenter + radius) {
            System.out.println(true);
            return;
        }
        for (int[] corner : corners) {
            if (dist(corner[0], corner[1], xCenter, yCenter) <= radius) {
                System.out.println(true);
                return;
            }
        }
        if (xCenter >= x1 & xCenter <= x2) {
            for (int e : new int[] { y1, y2 }) {
                if (e >= yCenter - radius & e <= yCenter + radius) {
                    System.out.println(true);
                    return;
                }
            }
        }
        if (yCenter >= y1 & yCenter <= y2) {
            for (int e : new int[] { x1, x2 }) {
                if (e >= xCenter - radius & e <= xCenter + radius) {
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);
        return;
    }

    public static double dist(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
