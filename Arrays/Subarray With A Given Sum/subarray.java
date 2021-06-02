import java.util.*;

public class subarray {
    public static int subArraySumPositive(int[] arr, int sum){
        int start = 0;
        int currSum = arr[0];

        for(int i=1;i<=arr.length;i++){
            while(currSum > sum && start < i-1){
                currSum -= arr[start++];             
            }

            if(currSum == sum ){
                int end = i-1;
                System.out.println("Subarray found between " + start + " and " + end);
                return 1;
            }

            if(i<arr.length){
                currSum+=arr[i];
            }
        }

        System.out.println("No Subbarray Found");
        return -1;
    }

    public static int subArraySumNegative(int[] arr, int sum) {
    int count = 0, currSum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (map.containsKey(currSum - sum)){
                count += map.get(currSum - sum);
            }
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        if(count>0){
            System.out.println("No of subarrays is " + count);
            return count;
        }
            System.out.println("No subarrays present");
            return -1;
    }

    

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,7,5};
        int sum1 = 12;
        // subArraySumPositive(arr1,sum1);
        subArraySumNegative(arr1, sum1);
        
        
        int[] arr2 =  {1,2,3,4,5,6,7,8,9,10};
        int sum2=15;
        // subArraySumPositive(arr2, sum2);
        subArraySumNegative(arr2, sum2);

        int[] arr3 = {3,4,7,2,-3,1,4,2};
        int sum3 = 7;
        subArraySumNegative(arr3, sum3);
       
    }
}
