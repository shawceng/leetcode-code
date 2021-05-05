package lcof;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int num = 0, vote = 0;
        for (int e :
                nums) {
            if (vote == 0)
                num = e;
            vote += num == e ? 1 : -1;
        }
        return num;
    }
}
