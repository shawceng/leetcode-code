package sort;

import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] numsWords = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsWords[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsWords, (a, b) ->
            (a + b).compareTo(b + a)
        );

        if (numsWords[0].equals("0")) return "0";
        return String.join("", numsWords);
    }
}
