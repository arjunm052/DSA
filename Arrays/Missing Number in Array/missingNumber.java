//You are given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in the list. One of the integers is missing in the list. Write an efficient code to find the missing integer

import java.util.*;

public class missingNumber {
    public static void missingNum(int arr[]) {
        int n = arr.length + 1;
        int nSum = (n * (n + 1)) / 2;
        int arrSum = 0;
        for (int i = 0; i < arr.length; i++) {
            arrSum += arr[i];
        }
        System.out.println("Missing number is " + (nSum - arrSum));
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 6, 3, 7, 8 };
        missingNum(arr);
        int arr2[] = { 1, 2, 3, 5 };
        missingNum(arr2);
    }
}
