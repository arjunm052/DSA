import java.util.*;

public class count {
    public static void main(String[] args) {
        int[] arr = { 0, 0, 1, 1, 1, 1, 2, 3, 4, 5, 6 };
        int key = 1;
        int fi = first(arr, key);
        int la = last(arr, key);
        if (fi == -1) {
            System.out.println(-1);
            return;
        }
        System.out.println(la - fi + 1);
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
