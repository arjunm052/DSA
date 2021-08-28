/*
Given an array of N positive Integers, the task if to find max of j-i 
subjectted to constraint such that A[i]<=A[j]
*/

import java.util.*;

public class maxIndex {
    public static void main(String[] args) {
        int[] arr = { 34, 8, 10, 3, 2, 80, 30, 33, 1 };
        System.out.println(jMinusi(arr));
    }

    public static int jMinusi(int[] arr) {
        int res = Integer.MIN_VALUE;
        int n = arr.length;
        int LMin[] = new int[n];
        int RMax[] = new int[n];

        LMin[0] = arr[0];
        for (int i = 1; i < n; i++) {
            LMin[i] = Math.min(arr[i], LMin[i - 1]);
        }

        RMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            RMax[i] = Math.max(arr[i], RMax[i + 1]);
        }

        int i = 0, j = 0;
        while (i < n && j < n) {
            if (LMin[i] <= RMax[j]) {
                res = Math.max(res, j - i);
                j++;
            } else {
                i++;
            }
        }

        return res;
    }
}
