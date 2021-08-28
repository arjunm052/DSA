import java.util.*;

public class ceil {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 8, 10, 10, 12, 19 };
        int key = 25;
        System.out.println(ceil(arr, key));
    }

    public static int ceil(int[] arr, int key) {
        int res = Integer.MAX_VALUE;
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                res = arr[mid];
                break;
            } else if (arr[mid] > key && arr[mid] < res) {
                res = arr[mid];
            }
            if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return res;
    }
}
