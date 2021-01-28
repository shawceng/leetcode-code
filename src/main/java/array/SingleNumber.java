package array;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int number = 0;
        for (int each:
             nums) {
            number ^= each;
        }
        return number;
    }
}
