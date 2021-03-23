package lcof;

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int two = 0, three = 0;
        for (int num:
             nums) {
            int t = num & three;
            three ^= two & num;
            two |= num;
            two -= t;
        }
        return two;
    }
}
