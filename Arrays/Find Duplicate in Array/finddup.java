import java.util.*;

public class finddup {
    public static void main(String[] args) {
       int[] arr = {1,3,4,2,2};
       int[] arr1 = {3,1,3,4,2}; 
       int[] arr2 = {1,1}; 
       int[] arr3 = {1,1,2};
       
       System.out.println(findDupli(arr1));
    }

    public static int findDupli(int[] arr) {
        int res = -1;
        for(int i=0;i<arr.length;i++){
            int ind = Math.abs(arr[i]);
            if(arr[ind]<0){
                res = ind;
                break;
            }
            arr[ind]=-arr[ind];
        }
        return res;
    }

}
