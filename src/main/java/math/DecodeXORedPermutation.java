package math;

public class DecodeXORedPermutation {
    public int[] decode(int[] encoded) {
        int[] ret = new int[encoded.length + 1];
        int abcd = 0;
        for (int i = 0; i < encoded.length + 1; i++) {
            abcd ^= i + 1;
        }
        int bcd = 0;
        for (int i = 1; i < encoded.length; i+= 2) {
            bcd ^= encoded[i];
        }
        ret[0] = abcd ^ bcd;
        for (int i = 1; i < ret.length; i++) {
            ret[i] = encoded[i - 1] ^ ret[i - 1];
        }
        return ret;
    }
}
