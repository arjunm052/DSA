import java.util.*;

public class revarr {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int[] arr1 = {1,2};
        reverse(arr);
        reverse(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    public static void reverse(int[] arr) {
        int i = 0,j = arr.length-1;
        while(i<j){
            swap(arr,i++,j--);
        }
    }

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
