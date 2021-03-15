package detail;

public class TextJustificationTest {
    public static void main(String[] args) {
        TextJustification tj = new TextJustification();
        System.out.println(tj.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
    }
}
