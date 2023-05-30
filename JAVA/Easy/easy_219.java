import java.util.ArrayList;
import java.util.Comparator;

public class easy_219 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        int k = 3;

        ArrayList<int[]> list = new ArrayList<int[]>();
        for (int i = 0; i < nums.length; i++) {
            int[] tmp = { nums[i], i };
            list.add(tmp);
        }

        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                if (o1[0] != o2[0])
                    return o1[0] - o2[0];
                else
                    return o1[1] - o2[1];
            }
        });

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i)[0] == list.get(i - 1)[0] && list.get(i)[1] - list.get(i - 1)[1] <= k)
                System.out.println(i);
        }
    }
}
