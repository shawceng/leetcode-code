package lcof;

public class ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuilder ret = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ')
                ret.append("%20");
            else
                ret.append(c);
        }
        return ret.toString();
    }
}
