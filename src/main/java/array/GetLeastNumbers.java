package array;

import java.util.Arrays;

public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0) return new int[0];
        Arrays.sort(arr);
        int result[] = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public int[] getLeastNumbersInsert(int[] arr, int k) {
        if (arr.length == 0 || k == 0) return new int[0];
        int result[] = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }

        int maxIndex = findMax(result);

        for (int i = k; i < arr.length; i++) {
            if (result[maxIndex] > arr[i]) {
                result[maxIndex] = arr[i];
                maxIndex = findMax(result);
            }

        }
        return result;
    }

    public int findMax(int[] arr) {
        if (arr.length == 0) return -1;
        int max = arr[0], index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }

    public int[] getLeastNumbersQuickSelect(int[] arr, int k) {
        if (arr.length == 0 || k == 0) return new int[0];
        if (arr.length == k) return  arr;
        int pivot = 0;
        int from = 0, to = arr.length - 1;
        while (pivot != k) {
            pivot = partition(arr, from, to);
            if (pivot > k) {
                to = pivot - 1;
            } else if (pivot < k) {
                from = pivot + 1;
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        Arrays.sort(res);
        return res;
    }

    int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (i < j) {
            while (a[++i] < v && i < hi);
            while (a[--j] > v && j > lo);

            if (i < j) {
                swap(a, i, j);
            }
        }
        swap(a, lo, j);

        // a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

