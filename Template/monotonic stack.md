LeetCode 496

>nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。


```java
int n1 = nums1.length;
int n2 = nums2.length;
HashMap<Integer, Integer> num2index = new HashMap<Integer, Integer>();
for (int i = 0; i < n1; i++) {
    num2index.put(nums1[i], i);
}
Stack<Integer> stack = new Stack<Integer>();
int[] ans = new int[n1];
Arrays.fill(ans, -1);
for (int i = 0; i < n2; i++) {
    if (stack.isEmpty() || nums2[i] < stack.peek()) {
        stack.push(nums2[i]);
        continue;
    }
    while (!stack.isEmpty() && stack.peek() < nums2[i]) {
        int top = stack.pop();
        if (num2index.containsKey(top)) {
            ans[num2index.get(top)] = nums2[i];
        }
    }
    stack.push(nums2[i]);
}

for (int i : ans)
    System.out.println(i);
```