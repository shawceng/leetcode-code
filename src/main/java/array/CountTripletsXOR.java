package array;

public class CountTripletsXOR {
    public int countTriplets(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1, xor = arr[i]; j < arr.length; j++) {
                xor ^= arr[j];
                if (xor == 0) {
                    count += j - i;
                }
            }
        }
        return count;
    }
}
