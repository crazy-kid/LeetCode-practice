# 树状数组 Fenwick tree

## 用途

1. 查询、修改单个元素. 时间复杂度：$\mathcal O(\log n)$
2. 查询连续区间和. 时间复杂度：$\mathcal O(\log n)$

## Java模板

```Java
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
```

## 参考资料

> <https://www.bilibili.com/video/BV1Ez4y1Y7Az/?spm_id_from=333.337.search-card.all.click&vd_source=d4271b6eacb73942c28e1384bb8e8bd7>
> <https://en.wikipedia.org/wiki/Fenwick_tree>
