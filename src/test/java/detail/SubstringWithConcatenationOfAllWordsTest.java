package detail;

public class SubstringWithConcatenationOfAllWordsTest {
    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords swca = new SubstringWithConcatenationOfAllWords();
        System.out.println(swca.findSubstring("wordgoodgoodgoodbestword", new String[]{"good", "best", "word", "good"}));
    }
}
