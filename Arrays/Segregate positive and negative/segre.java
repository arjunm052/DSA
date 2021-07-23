import java.util.*;

public class segre {
    public static void main(String[] args) {
        int arr[] = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
        segregate(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void segregate(int[] arr) {
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                swap(arr,i,count++);
            }
        }
    }

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
