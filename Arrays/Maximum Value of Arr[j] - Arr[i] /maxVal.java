import java.util.*;

public class maxVal {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        System.out.println(maxDifference(arr));
    }

    public static int maxDifference(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return -1;
        }
        int res = arr[1] - arr[0];
        int minVal = arr[0];
        for (int i = 0; i < n; i++) {
            res = Math.max(res, arr[i] - minVal);
            minVal = Math.min(minVal, arr[i]);
        }
        return res;
    }
}
