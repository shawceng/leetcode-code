package detail;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        int len = s.length(), k = numRows * 2 - 2;
        StringBuilder path = new StringBuilder();
        for (int i = 0; i < len; i += k) {
            path.append(s.charAt(i));
        }
        for (int j = 1; j < numRows - 1; j++) {
            for (int i = j; i < len; i += k) {
                path.append(s.charAt(i));
                if (i - j + k - j < len)
                    path.append(s.charAt(i - j + k - j));
            }
        }
        for (int i = numRows - 1; i < len; i += k) {
            path.append(s.charAt(i));
        }
        return path.toString();
    }
}
