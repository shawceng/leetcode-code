package string;

public class PermutationTest {
    public static void main(String[] args) {
        Permutation p = new Permutation();
        String result[] = p.permutationDict("129876");
        for (String s:
             result) {

            System.out.println(s);
        }
    }
}
