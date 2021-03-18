package lcof;

public class ValidNumberTest {
    public static void main(String[] args) {
        ValidNumber vn = new ValidNumber();
        String[] strings = {"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789", "0.e3"};
        String[] stringss = {"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"};
        for (String s:
             stringss) {
            System.out.println(vn.isNumber(s));
        }
    }
}
