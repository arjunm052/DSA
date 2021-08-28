import java.util.*;

public class sortedRotated {
    public static void main(String[] args) {
        int arr[] = { 15, 18, 2, 3, 6, 12 };
        System.out.println(rightRotation(arr));
        System.out.println(leftRotation(arr));
    }

    public static int rightRotation(int[] arr) {
        int res = 0;
        int n = arr.length;
        if (n == 1) {
            return 0;
        }
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int next = (mid + 1) % n;
            int prev = (mid - 1) % n;

            if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
                res = mid;
                break;
            } else if (arr[mid] <= arr[end]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return res;
    }

    public static int leftRotation(int[] arr) {
        int res = 0;
        int n = arr.length;
        if (n == 1) {
            return 0;
        }
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int next = (mid + 1) % n;
            int prev = (mid - 1) % n;

            if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
                res = mid;
                break;
            } else if (arr[mid] <= arr[end]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return (n - res) % n;
    }
}
