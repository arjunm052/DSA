import java.util.*;

public class maxBitonic {
    public static void main(String[] args) {
        int[] arr = { 8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1 };
        System.out.println(findMax(arr));
    }

    public static int findMax(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return arr[start];
    }
}
