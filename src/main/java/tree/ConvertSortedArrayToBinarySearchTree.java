package tree;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return toBST(nums, 0, nums.length);
    }

    private TreeNode toBST(int[] nums, int from, int to) {
        if (from >= to) return null;
        int mid = from + (to - from) / 2;
        TreeNode left = toBST(nums, from, mid);
        TreeNode right = toBST(nums, mid + 1, to);
        return new TreeNode(nums[mid], left, right);
    }
}
