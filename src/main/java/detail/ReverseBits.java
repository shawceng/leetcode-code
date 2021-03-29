package detail;

public class ReverseBits {
    public int reverseBits(int n) {
        int ret = 0;
        int flag = (0x1 & n) << 31;
        for (int i = 1; i < 32; i++) {
            ret = (ret << 1) + ((n >> 1) & 0x1);
            n = n >> 1;
        }
        return ret | flag;
    }
}
