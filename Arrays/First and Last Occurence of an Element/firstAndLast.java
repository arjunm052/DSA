import java.util.*;

public class firstAndLast {
    public static void main(String[] args) {
        int[] arr = { 0, 0, 1, 1, 1, 1, 2, 3, 4, 5, 6 };
        int key = 1;
        System.out.println(first(arr, key));
        System.out.println(last(arr, key));
    }

    public static int first(int[] arr, int key) {
        int res = -1;
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == key) {
                res = mid;
                end = mid - 1;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return res;
    }

    public static int last(int[] arr, int key) {
        int res = -1;
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == key) {
                res = mid;
                start = mid + 1;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return res;
    }
}
