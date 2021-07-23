import java.util.*;

public class minmax {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        minmaxarr(arr);
    }
    
    public static void minmaxarr(int[] arr) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }
        System.out.println("Min Element: " + min);
        System.out.println("Max Element: " + max);

    }
}
