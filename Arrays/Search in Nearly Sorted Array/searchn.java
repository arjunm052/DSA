import java.util.*;

public class searchn {
    public static void main(String[] args) {
        int[] arr = { 10, 3, 40, 20, 50, 80, 70 };
        int key = 400;
        System.out.println(search(arr, key));
    }

    public static int search(int[] arr, int key) {
        int res = -1;
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == key) {
                res = mid;
                break;
            } else if (start <= mid - 1 && arr[mid - 1] == key) {
                res = mid - 1;
                break;
            } else if (end >= mid + 1 && arr[mid + 1] == key) {
                res = mid + 1;
                break;
            } else if (arr[mid] > key) {
                end = mid - 2;
            } else {
                start = mid + 2;
            }
        }
        return res;
    }
}
