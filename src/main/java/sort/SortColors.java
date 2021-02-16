package sort;

public class SortColors {
    public void sortColors(int[] nums) {
        int from = 0, to = nums.length - 1;
        for (int i = 0; i <= to; ) {
            if (nums[i] == 0)
                swap(nums, i++, from++);
            else if (nums[i] == 2)
                swap(nums, i, to--);
            else
                i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
