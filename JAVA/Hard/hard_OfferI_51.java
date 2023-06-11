package JAVA.Hard;

public class hard_OfferI_51 {

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7 };
        System.out.println(mergeSort(nums, 0, nums.length - 1));
    }

    public static int mergeSort(int[] nums, int left, int right) {
        int ans = 0;
        if (left >= right)
            return 0;
        int mid = left + (right - left) / 2;
        ans += mergeSort(nums, left, mid);
        ans += mergeSort(nums, mid + 1, right);
        int[] tmp = new int[right - left + 1];
        int cur1 = left;
        int cur2 = mid + 1;
        int cur = 0;
        while (!(cur1 > mid & cur2 > right)) {
            if (cur2 > right || (cur1 <= mid && nums[cur1] <= nums[cur2])) {
                tmp[cur] = nums[cur1];
                ans += cur2 - (mid + 1);
                cur1++;
            } else {
                tmp[cur] = nums[cur2];
                ans += mid - cur1 + 1;
                cur2++;
            }
            cur++;
        }
        for (int i = 0; i < right - left + 1; i++) {
            nums[left + i] = tmp[i];
        }
        return ans;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
