import java.util.ArrayList;

public class mid_1253 {
    public static void main(String[] args) {
        int upper = 2;
        int lower = 1;
        int[] colsum = { 1, 1, 1 };

        ArrayList<Integer> upArray = new ArrayList<Integer>();
        ArrayList<Integer> lowArray = new ArrayList<Integer>();
        int upLeft = upper;
        int lowLeft = lower;

        for (int e : colsum) {
            switch (e) {
                case 0:
                    upArray.add(0);
                    lowArray.add(0);
                    break;
                case 2:
                    upArray.add(1);
                    lowArray.add(1);
                    upLeft--;
                    lowLeft--;
                    break;
                case 1:
                    if (upLeft >= lowLeft) {
                        upArray.add(1);
                        lowArray.add(0);
                        upLeft--;
                    } else {
                        upArray.add(0);
                        lowArray.add(1);
                        lowLeft--;
                    }
            }
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (upLeft == 0 & lowLeft == 0) {
            ans.add(upArray);
            ans.add(lowArray);
        }
        return;
    }
}
