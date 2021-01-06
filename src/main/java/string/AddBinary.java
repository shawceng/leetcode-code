package string;


public class AddBinary {
    public String addBinary(String a, String b) {
        int alen = a.length(), blen = b.length();
        int maxLen = Math.max(alen, blen);

        StringBuilder sb = new StringBuilder();
        int carry = 0;

        for (int i = 0; i < maxLen; i++) {
            int ai = alen - i - 1 >= 0 ? a.charAt(alen - i - 1) - '0' : 0;
            int bi = blen - i - 1 >= 0 ? b.charAt(blen - i - 1) - '0' : 0;
            int v = carry + ai + bi;
            sb.insert(0, (char) ('0' + (v % 2)));
            carry = v / 2;
        }

        while (carry > 0) {
            sb.insert(0, (char) ('0' + (carry % 2)));
            carry /= 2;
        }
        return sb.toString();
    }
}
