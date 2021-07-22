import java.util.*;

public class binary {
    
    public static int posOfFirstOne(int[] arr) {
        int start= 0;
        int end = 1;
        int res = Integer.MAX_VALUE;

        while(arr[end]!=1 && end*2<arr.length){
            start=end;
            end*=2;
        }

        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid]==1 && mid<res){
                res=mid;
                end=mid-1;
            }
            if(arr[mid]==0){
                start=mid+1;
            } else {
                end=mid-1;
            }
            
        }
        
        if(res==Integer.MAX_VALUE){
            return -1;
        } else{
            return res;
        }
    }
    public static void main(String[] args) {
        int arr[] = { 0,0,0,0,0,0,0};
        System.out.println(posOfFirstOne(arr));
       
    }
}
