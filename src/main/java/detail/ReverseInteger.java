package detail;

public class ReverseInteger {
    int MAX = Integer.MAX_VALUE;
    int MIN = Integer.MIN_VALUE;

    public int reverse(int x) {
        int ret = 0;
        int flag = x > 0 ? 1 : -1;
        while (x != 0) {
            int v = x % 10;
            if((flag == 1 && (ret > MAX / 10 || (ret == MAX / 10 && v > MAX % 10)))
                || (flag == -1 && (ret < MIN / 10 || (ret == MIN / 10 && v < MIN % 10)))) {
                return 0;
            }
            ret = ret * 10 + v;
            x /= 10;
        }
        return ret * flag;
    }
}
