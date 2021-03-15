package string;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        String s = "11";
        int t = 2;
        while (t++ < n)
            s = getNext(s);
        return s;
    }

    private String getNext(String s) {
        StringBuilder ret = new StringBuilder();

        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                ret.append(count);
                ret.append(s.charAt(i - 1));
                count = 1;
            }
        }
        ret.append(count);
        ret.append(s.charAt(s.length() - 1));
        return ret.toString();
    }
}
