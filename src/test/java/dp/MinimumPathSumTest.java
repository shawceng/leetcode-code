package dp;

public class MinimumPathSumTest {
    public static void main(String[] args) {
        MinimumPathSum mps = new MinimumPathSum();
        int ret = mps.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        System.out.println(ret);
    }
}
