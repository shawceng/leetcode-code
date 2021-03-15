package string;

public class IntegerToRoman {
    public String intToRoman(int num) {
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder ret = new StringBuilder();

        while (num != 0) {
            int i = 0;
            while (num < nums[i]) i++;
            int val = num / nums[i] * nums[i];
            ret.append(symbols[i].repeat(num / nums[i]));
            num %= nums[i];
        }
        return ret.toString();
    }
}
