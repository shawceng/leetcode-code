package search;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int e = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == e) {
                count++;
            } else if (count == 1) {
                e = nums[i];
            } else {
                count--;
            }
        }
        return e;
    }
}
