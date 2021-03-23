package lcof;

public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int t = 0;
        for (int num:
             nums) {
            t ^= num;
        }
        t &= ~(t - 1);
        int a = 0;
        int b = 0;
        for (int num:
             nums) {
            if ((num & t) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
