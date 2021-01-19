package array;

import java.net.UnknownServiceException;
import java.util.HashSet;
import java.util.Set;

public class RemoveStones {
    public class UFS {
        private int[] p;

        public UFS(int rank) {
            p = new int[rank];
            for (int i = 0; i < rank; i++) {
                p[i] = i;
            }
        }

        public int find(int x) {
            if (p[x] != x) {
                return find(p[x]);
            }
            return p[x];
        }

        public void union(int x, int y) {
            int xr = find(x);
            int yr = find(y);
            p[xr] = yr;
        }
    }

    public int removeStones(int[][] stones) {
        UFS ufs = new UFS(20002);
        for (int i = 0; i < stones.length; i++) {
            ufs.union(stones[i][0], stones[i][1] + 10000);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < stones.length; i++) {
            set.add(ufs.find(stones[i][0]));
        }
        return stones.length - set.size();
    }
}
