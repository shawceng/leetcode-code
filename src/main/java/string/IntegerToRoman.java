package string;

public class IntegerToRoman {
    final int[] nums = new int[]{
            1, 4, 5, 9, 10,
            40, 50, 90, 100,
            400, 500, 900, 1000
    };
    final String[] roman = new String[]{
            "I", "IV", "V", "IX", "X",
            "XL", "L", "XC", "C",
            "CD", "D", "CM", "M"
    };
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int i = roman.length - 1;
        while (num != 0) {
            for (; i > 0 && nums[i] > num; i--);
            sb.append(roman[i].repeat(num / nums[i]));
            num %= nums[i];
        }
        return sb.toString();
    }
}
