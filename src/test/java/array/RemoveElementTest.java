package array;

public class RemoveElementTest {
    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(re.removeElement(nums, 2));

    }
}
