import java.util.*;

public class repeating {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 1, 3, 6, 6 };
        repeating(arr);
    }

    public static void repeating(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = Math.abs(arr[i]);
            if (arr[j] >= 0) {
                arr[j] = -arr[j];
            } else {
                System.out.print(j + " ");
            }
        }
    }
}
