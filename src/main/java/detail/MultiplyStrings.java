package detail;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int len2 = num2.length();
        if (len2 > num1.length()) return multiply(num2, num1);
        String ret = "";
        for (int i = 0; i < len2; i++) {
            String s = multiply(num1, num2.charAt(len2 - i - 1));
            ret = add(ret, s + "0".repeat(i));
        }
        return ret;
    }

    private String multiply(String num, char t) {
        if (t == '0') return "0";
        StringBuilder ret = new StringBuilder();
        int carry = 0;
        int n = t - '0';
        int len = num.length();
        for (int i = 0; i < len; i++) {
            int val = (num.charAt(len - i - 1) - '0') * n;
            ret.insert(0, ((val + carry) % 10));
            carry = (val + carry) / 10;
        }
        if (carry != 0) {
            ret.insert(0, carry);
        }
        return ret.toString();
    }

    private String add(String num1, String num2) {
        StringBuilder sum = new StringBuilder();
        int carry = 0;
        int len1 = num1.length(), len2 = num2.length();
        for (int i = 0; i < len1 || i < len2; i++) {
            int a = i < len1 ? num1.charAt(len1 - i - 1) - '0' : 0;
            int b = i < len2 ? num2.charAt(len2 - i - 1) - '0' : 0;
            sum.insert(0, ((a + b + carry) % 10));
            carry = (a + b + carry) / 10;
        }
        if (carry != 0) {
            sum.insert(0, carry);
        }
        return sum.toString();
    }
}
