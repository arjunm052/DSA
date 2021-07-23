import java.util.*;

public class kadane {
    public static void main(String[] args) {
        int arr[] = {1,2,3,-2,5};
        int arr2[] =  {-1,-2,-3,-4};
        System.out.println(maxSum(arr2));
    }

    public static int maxSum(int[] arr) { 
        int currMax = arr[0];
        int maxSoFar = arr[0];

        for(int i=1;i<arr.length;i++){
            currMax=Math.max(arr[i],currMax+arr[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }

        return maxSoFar;
    }
}
