import java.util.*;

public class moveZeros {
    public static void main(String[] args) {
        int[] arr = { 1, 0, 0, 1, 1, 1, 0, 1, 0 };
        moveZero(arr);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    public static void moveZero(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                swap(arr, i, count);
                count++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
