import java.util.*;

public class smallestLetter {
    public static void main(String[] args) {
        char[] arr = { 'c', 'f', 'j' };
        char target = 'c';
        System.out.println(nextGreatestLetter(arr, target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        int res = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (letters[mid] == target) {
                start = mid + 1;
            }

            if (letters[mid] > target && mid < res) {
                res = mid;
            }

            if (letters[mid] > target) {
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }

        if (res == Integer.MAX_VALUE) {
            return letters[0];
        } else {
            return letters[res];
        }
    }
}
