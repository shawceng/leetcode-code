package string;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String s1 = strs[0];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length() < i + 1 || s1.charAt(i) != strs[j].charAt(i))
                    return s1.substring(0, i);
            }
        }
        return s1;
    }
}
