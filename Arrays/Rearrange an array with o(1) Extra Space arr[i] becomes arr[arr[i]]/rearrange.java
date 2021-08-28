import java.util.*;

public class rearrange {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 0, 1 };
        rearrangeArray(arr);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    public static void rearrangeArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] + (arr[arr[i]] % n) * n;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / n;
        }
    }
}
