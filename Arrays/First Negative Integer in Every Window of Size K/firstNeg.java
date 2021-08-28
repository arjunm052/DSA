import java.util.*;

public class firstNeg {
    public static void main(String[] args) {
        int[] arr = { -8, 2, 3, -6, 10 };
        int k = 2;
        System.out.println(Arrays.toString(solve(arr, k)));
    }

    public static int[] solve(int[] arr, int w) {
        int[] res = new int[arr.length];
        Queue<Integer> q = new LinkedList<>();
        int i = 0, j = 0, k = 0;
        for (j = 0; j < w; j++) {
            if (arr[j] < 0) {
                q.add(arr[j]);
            }
            if (q.isEmpty()) {
                res[k++] = 0;
            } else {
                res[k++] = q.peek();
            }
        }

        for (j = w; j < arr.length; j++) {
            if (arr[j] < 0) {
                q.add(arr[j]);
            }
            if (!q.isEmpty() && arr[i] == q.peek()) {
                q.remove();
                i++;
            } else {
                i++;
            }
            if (q.isEmpty()) {
                res[k++] = 0;
            } else {
                res[k++] = q.peek();
            }
        }
        return res;
    }
}
