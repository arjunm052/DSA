import java.util.*;

public class subarray {
    public static int subArraySumPositive(int[] arr,int n, int sum){
        int start = 0;
        int currSum = arr[0];

        for(int i=1;i<=n;i++){
            while(currSum > sum && start < i-1){
                currSum -= arr[start++];             
            }

            if(currSum == sum ){
                int end = i-1;
                System.out.println("Subarray found between " + start + " and " + end);
                return 1;
            }

            if(i<n){
                currSum+=arr[i];
            }
        }

        System.out.println("No Subbarray Found");
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,7,5};
        int n1 = 5, sum1 = 12;
        subArraySumPositive(arr1,n1,sum1);
        
        int[] arr2 =  {1,2,3,4,5,6,7,8,9,10};
        int n2=10,sum2=15;
        subArraySumPositive(arr2, n2, sum2);
    }
}
