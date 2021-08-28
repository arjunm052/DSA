import java.util.*;

public class inversion {
    public static void main(String[] args) {
        int[] arr = { 8, 4, 2, 1 };
        System.out.println(countInv(arr, 0, arr.length - 1));
    }

    public static int countInv(int[] arr, int low, int high) {
        int res = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            res += countInv(arr, low, mid);
            res += countInv(arr, mid + 1, high);
            res += countAndMerge(arr, low, mid, high);
        }
        return res;
    }

    public static int countAndMerge(int[] arr, int low, int mid, int high) {
        int left[] = Arrays.copyOfRange(arr, low, mid + 1);
        int right[] = Arrays.copyOfRange(arr, mid + 1, high + 1);
        int i = 0, j = 0, k = low;
        int swaps = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                swaps += ((mid + 1 - low) - i);
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }

        return swaps;
    }
}
