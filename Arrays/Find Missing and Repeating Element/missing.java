import java.util.*;

public class missing {
    public static void main(String[] args) {
        int[] arr = { 4, 3, 6, 2, 1, 1 };
        findMissing(arr);
    }

    public static void findMissing(int[] arr) {
        int i = 0;
        int n = arr.length;
        while (i < n) {
            if (arr[i] != arr[arr[i] - 1]) {
                swap(arr, i, arr[i] - 1);
            } else {
                i++;
            }
        }

        for (int j = 0; j < n; j++) {
            if (arr[j] != j + 1) {
                System.out.println("Missing Number: " + (j + 1));
                System.out.println("Repeating Number: " + (arr[j]));
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
