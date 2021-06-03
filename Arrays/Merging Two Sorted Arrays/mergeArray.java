import java.util.*;

public class mergeArray {
    public static void merge(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = arr1.length - 1;
        while (i <= k && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else {
                int temp = arr2[j];
                arr2[j] = arr1[k];
                arr1[k] = temp;
                j++;
                k--;
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        System.out.println("First Array: " + Arrays.toString(arr1));
        System.out.print("Second Array: " + Arrays.toString(arr2));

    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 5, 9, 10, 15, 20 };
        int[] arr2 = { 2, 3, 8, 13 };
        merge(arr1, arr2);
    }
}
