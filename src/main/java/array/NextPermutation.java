package array;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int to = nums.length - 1;
        while (to > 0 && nums[to - 1] >= nums[to]) to--;
        if (to == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int pivot = to - 1;
        while (to < nums.length && nums[to] > nums[pivot]) to++;

        swap(nums, pivot, to - 1);
        reverse(nums, pivot + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void reverse(int[] nums, int from, int to) {
        for (; from < to; from++, to--) {
            swap(nums, from, to);
        }
    }
}
