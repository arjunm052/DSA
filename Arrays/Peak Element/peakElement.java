import java.util.*;

public class peakElement {
    public static void main(String[] args) {
        int[] arr = { 5, 10, 20, 15 };
        System.out.println(peak(arr));
    }

    public static int peak(int[] arr) {
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
