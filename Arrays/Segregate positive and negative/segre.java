import java.util.*;

public class segre {
    public static void main(String[] args) {
        int arr[] = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
        segregate(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void segregate(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                swap(arr, i, count++);
            }
        }
    }

    public static void segregateWithOrder(int[] arr) {
        int count_negative = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++)
            if (arr[i] < 0)
                count_negative++;

        // Run a loop until all
        // negative numbers are
        // moved to the beginning
        int i = 0, j = i + 1;
        while (i != count_negative) {

            // If number is negative,
            // update position of next
            // positive number.
            if (arr[i] < 0) {
                i++;
                j = i + 1;
            }

            // If number is positive, move
            // it to index j and increment j.
            else if (arr[i] > 0 && j < n) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                j++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
