import java.util.*;

public class floor {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 8, 10, 10, 12, 19 };
        int key = 20;
        System.out.println(floor(arr, key));
    }

    public static int floor(int[] arr, int key) {
        int res = -1;
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                res = arr[mid];
                break;
            } else if (arr[mid] < key && arr[mid] > res) {
                res = arr[mid];
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }
}
