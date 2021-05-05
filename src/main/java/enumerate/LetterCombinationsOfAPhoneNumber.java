package enumerate;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    private String[] letters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;
        StringBuilder path = new StringBuilder(digits.length());
        conbine(result, path, digits, 0);
        return result;
    }

    private void conbine(List<String> result, StringBuilder path, String digits, int index) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }
        int i = digits.charAt(index) - '0';
        for (char c :
                letters[i].toCharArray()) {
            path.append(c);
            conbine(result, path, digits, index + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
