package array;

public class NextPermutationTest {
    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] nums = {5, 1, 1};
        np.nextPermutation(nums);
        for (int each :
                nums) {
            System.out.println(each);

        }

    }
}
