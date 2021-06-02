//Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.
import java.util.*;

public class triplets {

    public static int countTriplet(int[] arr) {
        int count = 0;
        for(int i=0;i<arr.length-1;i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j=i+1;j<arr.length;j++){
                if(set.contains(arr[i]+arr[j]) || set.contains(arr[i]-arr[j]) || set.contains(arr[j]-arr[i])){
                    count++;
                } else {
                    set.add(arr[j]);
                 }
             }
        }

            System.out.println("No. of triplets present is " + count);
            return count;
        }

    

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 3, 2};
        int[] arr2 = {2, 3, 4};
        countTriplet(arr1);
        countTriplet(arr2);
    }
}
