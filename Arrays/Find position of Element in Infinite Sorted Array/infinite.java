import java.util.*;

public class infinite {
    public static void main(String[] args) {

    }

    public static int infinte(int[] arr, int key) {
        int res = -1;
        int start = 0, end = 1;
        while (arr[end] < key) {
            start = end;
            end = end * 2;
        }

        return search(arr, key, start, end);
    }

    public static int search(int[] arr, int key, int start, int end) {
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == key) {
                ans = mid;
                break;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
