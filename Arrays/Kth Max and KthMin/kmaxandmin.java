import java.util.*;

public class kmaxandmin {
    public static void main(String[] args) {
        int [] arr = {7, 10, 4, 3, 20, 15};
        int k =9;  
        System.out.println(kthMin(arr,0,arr.length-1,k-1)); 
    }


    public static int kthMin(int[] arr,int low,int high,int k) {
            if(low==high){
                return arr[low];
            }

            int part = partition(arr, low, high);

            if(part==k){
                return arr[part];
            }
            else if(k<part){
                return kthMin(arr, low, part-1, k);
            }
            else {
                return kthMin(arr, part+1, high, k);
            }
        }

    public static int partition(int[] arr,int low,int high) {
        int pivot = arr[high];
        int i = low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<=pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,high);
        return i+1;
    }

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}
