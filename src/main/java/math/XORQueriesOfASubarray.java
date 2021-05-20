package math;

public class XORQueriesOfASubarray {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefix = new int[arr.length + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] ^ arr[i - 1];
        }

        int[] ret = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ret[i] = prefix[queries[i][0]] ^ prefix[queries[i][1] + 1];
        }
        return ret;
    }
}
