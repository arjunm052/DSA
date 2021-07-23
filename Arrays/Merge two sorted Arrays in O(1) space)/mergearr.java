import java.util.*;

public class mergearr {
    public static void main(String[] args) {
        int arr1[] = {1, 3, 5, 7};
        int arr2[] = {0, 2, 6, 8, 9};
        merge(arr1, arr2);
        System.out.println(Arrays.toString(arr1) + Arrays.toString(arr2));
    }

    public static void merge(int[] a,int[] b) {
        int i = a.length-1,j=0;
        while(i>=0 && j<b.length){
            if(b[j]<a[i]){
                swap(a,b,i,j);
                i--;
                j++;
            }else{
                j++;
            }
        }

        Arrays.sort(a);
        Arrays.sort(b);
    }

    public static void swap(int[] arr1,int[] arr2,int i,int j) {
        int temp = arr1[i];
        arr1[i]=arr2[j];
        arr2[j]=temp;
    }
}
