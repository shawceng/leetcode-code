package detail;

public class ReverseInteger {
    int MAX = Integer.MAX_VALUE;
    int MIN = Integer.MIN_VALUE;

    public int reverse(int x) {
        int flag = x >= 0 ? 1 : -1;
        int ret = 0;
        for (int t = x * flag; t > 0; t /= 10) {
            int val = t % 10;
            if ((flag == 1 && (ret > MAX / 10 || (ret == MAX / 10 && val > MAX % 10)) )
                    || (flag == -1 && (ret > -(MIN / 10) || (ret == -(MIN / 10) && val > MAX % 10 + 1))))
                return 0;
            ret = ret * 10 + t % 10;
        }
        return flag * ret;
    }
}
