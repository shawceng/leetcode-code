package lcof;

public class ConstructArr {
    public int[] constructArr(int[] a) {
        int val = 1;
        boolean hasZero = false;
        for (int e:
             a) {
            if (e == 0 && !hasZero)
                hasZero = true;
            else
                val *= e;
        }
        int[] ret = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int e = a[i];
            if (hasZero) {
                if (e == 0)
                    ret[i] = val;
                else
                    ret[i] = 0;
            } else {
                ret[i] = val / e;
            }
        }
        return ret;
    }
}
