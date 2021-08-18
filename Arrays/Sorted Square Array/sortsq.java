import java.util.*;

public class sortsq {
    public static void main(String[] args) {
        int[] arr = { -4, -1, 0, 3, 10 };
        int[] res = sortedSquare(arr);
        System.out.println(Arrays.toString(res));
    }

    private static int[] sortedSquare(int[] arr) {
        int[] res = new int[arr.length];
        int start = 0;
        int end = arr.length - 1;

        for (int i = end; i >= 0; i--) {
            if (Math.abs(arr[start]) > Math.abs(arr[end])) {
                res[i] = arr[start] * arr[start];
                start++;
            } else {
                res[i] = arr[end] * arr[end];
                end--;
            }
        }
        return res;
    }
}
