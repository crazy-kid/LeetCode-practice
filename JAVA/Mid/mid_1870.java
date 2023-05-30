public class mid_1870 {
    public static void main(String[] args) {
        int[] dist = { 3,3 };
        double hour = 2.0;
        if (dist.length > Math.ceil(hour))
            return;
        int sum = 0;
        int max = 0;
        for (int e : dist) {
            sum += e;
            max = Math.max(e, max);
        }
        if (hour != Math.floor(hour))
            max = Math.max(max, (int) (Math.ceil(dist[dist.length - 1] / (hour - Math.floor(hour)))));
        int min = (int) (sum / hour);
        int mid = (min+max)/2;
        while (min < max) {
            mid = (min + max) / 2;
            if (isAvailable(dist, hour, mid)) {
                max = mid;
            } else {
                min = mid;
            }
            if (min == max - 1) {
                if (isAvailable(dist, hour, min)) {
                    mid = min;
                    break;
                } else {
                    mid = max;
                    break;
                }
            }
        }
        System.out.println(mid);
    }

    public static boolean isAvailable(int[] dist, double hour, int speed) {
        for (int i = 0; i < dist.length - 1; i++) {
            hour = hour - Math.ceil((double) dist[i] / (double) speed);
        }
        if (hour < 0)
            return false;
        else {
            double tmp = hour * speed;
            double d = dist[dist.length - 1];
            tmp = tmp - d;
            if (Math.abs(tmp) < 0.00001)
                return true;
            return tmp > 0;
        }
    }
}
