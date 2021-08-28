import java.util.*;

public class mindif {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 10, 12, 15 };
        int target = 6;
        System.out.println(minDiff(arr, target));
    }

    public static int minDiff(int[] arr, int key) {
        int res = Integer.MAX_VALUE;
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                res = arr[mid];
                return res;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (Math.abs(key - arr[start]) < res) {
            res = arr[start];
        }
        if (Math.abs(key - arr[end]) < res) {
            res = arr[end];
        }
        return res;
    }
}
