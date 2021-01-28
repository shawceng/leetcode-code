package array;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int acc = 0;
        for (int each:
             nums) {
            acc ^= each;
        }

        acc = acc & (-acc);

        int[] res = new int[2];
        for (int each:
             nums) {
            if ((each & acc) != 0)
                res[0] ^= each;
            else
                res[1] ^= each;
        }
        return res;
    }
}
