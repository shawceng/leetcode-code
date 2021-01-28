package array;

public class SingleNumberI {
    public int singleNumber(int[] nums) {
        int one = 0, tow = 0;
        for (int each:
             nums) {
            tow ^= (one & each);
            one ^= each;
            int val = tow & one;
            tow -= val;
            one -= val;
        }
        return one - tow;
    }
}
