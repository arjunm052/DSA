import java.util.*;

public class left {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        leftRotate(arr, 2);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    public static void leftRotate(int[] arr, int d) {
        int n = arr.length;
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }

    public static void reverse(int[] arr, int low, int high) {
        while (low < high) {
            swap(arr, low++, high--);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
