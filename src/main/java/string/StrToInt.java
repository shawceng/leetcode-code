package string;

public class StrToInt {
    public int strToInt(String s) {
        int result = 0;
        if (s.equals("")) return result;
        int sign = 1;
        int i = 0;
        while(i < s.length() && s.charAt(i) == ' ') i ++;
        if (i >= s.length() || (s.charAt(i) != '-' && s.charAt(i) != '+' && (s.charAt(i) > '9' || s.charAt(i) < '0')))
            return result;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i ++;
        }

        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int n = s.charAt(i) - '0';
            if (sign > 0 && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && n >= Integer.MAX_VALUE % 10)))
                return Integer.MAX_VALUE;
            if(sign < 0 && (-result < Integer.MIN_VALUE / 10 || (-result == Integer.MIN_VALUE / 10 && -n <= Integer.MIN_VALUE % 10)))
                return Integer.MIN_VALUE;
            result = result * 10 + n;
            i ++;
        }
        return sign * result;
    }
}
