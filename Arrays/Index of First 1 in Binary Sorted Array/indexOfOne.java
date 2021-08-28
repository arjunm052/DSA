import java.util.*;

public class indexOfOne {
    public static void main(String[] args) {

    }

    public static int indexOfOne(int[] arr) {
        int res = -1;
        int start = 0, end = 1;
        while (arr[end] != 1) {
            start = end;
            end = end * 2;
        }
        return first(arr, 1, start, end);
    }

    public static int first(int[] arr, int key, int start, int end) {
        int res = -1;
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
}
