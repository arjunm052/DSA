import java.util.*;

public class triplet {
    public static void main(String[] args) {
        int[] arr = new int[] { 0, -1, 2, -3, 1 };
        int sum = -2;
        triplets(arr, sum);
    }

    public static void triplets(int[] arr, int sum) {
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // initialize left and right
            int l = i + 1;
            int r = n - 1;
            int x = arr[i];
            while (l < r) {
                if (x + arr[l] + arr[r] == sum) {
                    // print elements if it's
                    // sum is given sum.
                    System.out.println(x + " " + arr[l] + " " + arr[r]);
                    l++;
                    r--;
                }

                // If sum of three elements
                // is less than 'sum' then
                // increment in left
                else if (x + arr[l] + arr[r] < sum)
                    l++;

                // if sum is greater than
                // given sum, then decrement
                // in right side
                else
                    r--;
            }
        }
    }
}
