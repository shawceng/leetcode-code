package dp;

public class PaintHouseIIITest {
    public static void main(String[] args) {
        PaintHouseIII ph = new PaintHouseIII();
        System.out.println(ph.minCost(new int[]{0, 0, 0, 0,0},
                new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}},
                5, 2, 3));
    }
}
