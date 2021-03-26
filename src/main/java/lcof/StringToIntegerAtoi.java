package lcof;

public class StringToIntegerAtoi {
    public int strToInt(String str) {
        str = str.trim();
        if (str.isEmpty()) return 0;
        int flag = 1;
        int ret = 0;
        int idx = 0;
        if (str.charAt(0) == '-') {
            flag = -1;
            idx++;
        } else if (str.charAt(0) == '+') {
            idx++;
        }
        for (; idx < str.length(); idx++) {
            int v = str.charAt(idx) - '0';
            if (v < 0 || v > 9) break;
            if (flag > 0
                    && (ret > Integer.MAX_VALUE / 10
                    || (ret == Integer.MAX_VALUE / 10 && v >= Integer.MAX_VALUE % 10)))
                return Integer.MAX_VALUE;
            if (flag < 0
                    && (ret > Integer.MAX_VALUE / 10
                    || (ret == Integer.MAX_VALUE / 10) && v >= Integer.MAX_VALUE % 10 + 1))
                return Integer.MIN_VALUE;
            ret = ret * 10 + v;
        }
        return ret;
    }
}
