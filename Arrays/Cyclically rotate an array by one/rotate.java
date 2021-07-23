import java.util.*;

public class rotate {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int arr2[] = {9, 8, 7, 6, 4, 2, 1, 3};
        rotateByOne(arr2,arr2.length);
        System.out.println(Arrays.toString(arr2));
    }

    public static void rotateByOne(int[] arr,int n) {
        if(n==1){
            return;
        }
        int key = arr[n-1];
        for(int i=n-2;i>=0;i--){
            arr[i+1]=arr[i];
        }
        arr[0]=key;
    }

    
}
