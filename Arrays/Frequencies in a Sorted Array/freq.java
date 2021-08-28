import java.util.*;

public class freq {
    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 2, 2, 2, 3, };
        printFreq(arr);
    }

    public static void printFreq(int[] arr) {
        int freq = 1, i = 1;
        while (i < arr.length) {
            while (i < arr.length && arr[i - 1] == arr[i]) {
                freq++;
                i++;
            }
            System.out.println(arr[i - 1] + " - " + freq);
            i++;
            freq = 1;
        }

        if (arr.length == 1 || arr[arr.length - 1] != arr[arr.length - 2]) {
            System.out.println(arr[arr.length - 1] + " - " + 1);
        }
    }
}
