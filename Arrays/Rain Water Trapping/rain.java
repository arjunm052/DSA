import java.util.*;

public class rain {
    public static void main(String[] args) {
        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(rain(arr));
    }

    public static int rain(int[] arr) {
        int sum = 0;
        int n = arr.length;
        int[] water = new int[n];
        int[] maxL = new int[n];
        int[] maxR = new int[n];

        maxL[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxL[i] = Math.max(arr[i], maxL[i - 1]);
        }

        maxR[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxR[i] = Math.max(arr[i], maxR[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            water[i] = Math.min(maxL[i], maxR[i]) - arr[i];
            sum += water[i];
        }

        return sum;
    }
}
