package lcof;

public class FindMinimumInRotatedSortedArrayII {
    public int minArray(int[] numbers) {
        int from = 0, to = numbers.length - 1;
        while (from < to) {
            int mid = from + (to - from) / 2;
            if (numbers[mid] > numbers[to]) {
                from = mid + 1;
            } else if (numbers[mid] < numbers[to]) {
                to = mid;
            } else {
                to--;
            }
        }
        return numbers[from];
    }
}
