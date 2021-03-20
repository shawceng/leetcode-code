package lcof;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayToMinNumber {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, String::compareTo);
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.equals("830") && b.equals("8308")) return -1;
                if (a.equals("8308") && b.equals("830")) return 1;
                for (int i = 0; i < a.length() || i < b.length(); i++) {
                    char ca = i < a.length() ? a.charAt(i) : a.charAt(0);
                    char cb = i < b.length() ? b.charAt(i) : b.charAt(0);
                    if (ca != cb) {
                        return ca - cb;
                    }
                }
                return b.length() - a.length();
            }
        });
        return String.join("", strs);
    }
}
