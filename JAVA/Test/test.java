package JAVA.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class test {

    public static void main(String[] args) {
        int a = 12;
        System.out.println(Integer.highestOneBit(a));
    }

    class BIT {
        // tree[0]不会被使用，为了代码简洁并且不陷入死循环
        private final int[] tree;

        public BIT(int n) {
            tree = new int[n];
        }

        public int lowBit(int i) {
            return i & (-i);
        }

        // 将下标 i 上的数设置为val
        public void inc(int i, int val) {
            int diff = val - tree[i];
            while (i < tree.length) {
                tree[i] += diff;
                i += lowBit(i); // 向上寻找父节点
            }
        }

        // 返回闭区间 [1, i] 的元素和
        public int sum(int i) {
            int res = 0;
            while (i > 0) {
                res += tree[i];

                /*
                 * 每次循环按照lowbit加前缀和
                 * 也可以等价地写成 i &= i - 1, 并且更快
                 */
                i -= lowBit(i);
            }
            return res;
        }

        // 返回闭区间 [left, right] 的元素和
        public int query(int left, int right) {
            return sum(right) - sum(left - 1);
        }
    }
}
