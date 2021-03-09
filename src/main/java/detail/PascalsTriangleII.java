package detail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i < rowIndex + 1; i++) {
            ret.add(1);
        }
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                ret.set(j, ret.get(j) + ret.get(j - 1));
            }
        }
        return ret;
    }
}
