package array;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, j = -1;
        for (int i = 0, sum = 0; i < gas.length; i++) {
            int val = gas[i] - cost[i];
            sum += val;
            total += val;
            if (sum < 0) {
                sum = 0;
                j = i;
            }
        }

        if (total < 0) return -1;
        return j + 1;
    }
}
