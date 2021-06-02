//Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers that has the largest sum.

import java.util.*;

public class kadane {

    public static void maxSubArraySum(int[] arr) {
        int max_so_far = Integer.MIN_VALUE;
        int max_end_here = 0;
        int start = 0, end = 0, s = 0;

        for (int i = 0; i < arr.length; i++) {
            max_end_here += arr[i];
            if (max_so_far < max_end_here) {
                max_so_far = max_end_here;
                start = s;
                end = i;
            }

            if (max_end_here < 0) {
                max_end_here = 0;
                s = i + 1;
            }
        }

        System.out.println("Maximum sum is " + max_so_far + " for array ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int b[] = { 1, 2, 3, -2, 5 };
        maxSubArraySum(a);
        maxSubArraySum(b);
    }
}
