package detail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>(numRows);
        if (numRows == 0) return ret;

        ret.add(new ArrayList<>(Arrays.asList(1)));
        List<Integer> last = null;
        for (int i = 2; i <= numRows; i++) {
            List<Integer> tmp = new ArrayList<>(i);
            tmp.add(1);
            for (int j = 2; j < i; j++) {
                tmp.add(last.get(j - 1) + last.get(j - 2));
            }
            tmp.add(1);
            last = tmp;
            ret.add(tmp);
        }
        return ret;
    }
}
