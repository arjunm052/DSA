import java.util.*;

public class searchRot {
    public static void main(String[] args) {
        int arr[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
        System.out.println(search(arr, 30));

    }

    public static int search(int[] arr, int key) {
        int res = -1;
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == key) {
                res = mid;
                break;
            }
            if (arr[start] <= arr[mid]) {
                if (key >= arr[start] && key <= arr[mid - 1]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            if (arr[mid] <= arr[end]) {
                if (key >= arr[mid] && key <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return res;
    }
}
