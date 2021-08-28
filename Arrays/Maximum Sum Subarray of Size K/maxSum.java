import java.util.*;

public class maxSum {
    public static void main(String[] args) {
        int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        int k = 4;
        System.out.println(maxSumArray(arr, k));
    }

    public static int maxSumArray(int[] arr, int k) {
        int res = Integer.MIN_VALUE;
        int i = 0, j = 0;
        int currSum = 0;
        for (j = 0; j < k; j++) {
            currSum += arr[j];
        }

        for (j = k; j < arr.length; j++) {
            currSum += arr[j] - arr[i++];
            res = Math.max(res, currSum);
        }

        return res;
    }
}
