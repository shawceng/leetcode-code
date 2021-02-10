package stackAndQueue;

public class EvaluateReversePolishNotationTest {
    public static void main(String[] args) {
        EvaluateReversePolishNotation erpn = new EvaluateReversePolishNotation();
        System.out.println(erpn.evalRPN(new String[]{"2","1","+","3","*"}));
    }
}
