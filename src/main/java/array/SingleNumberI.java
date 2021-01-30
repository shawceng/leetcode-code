package array;

public class SingleNumberI {
    public int singleNumber(int[] nums) {
        int one = 0, two = 0;
        for (int each:
             nums) {
            two ^= (one & each);
            one ^= each;
            int val = two & one;
            two -= val;
            one -= val;
        }
        return one - two;
    }
}
