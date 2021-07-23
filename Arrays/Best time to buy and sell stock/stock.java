import java.util.*;

public class stock {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxStock(arr));
    }

    public static int maxStock(int[] arr) {
        int res = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                res += (arr[i]-arr[i-1]);
            }
        }
        return res;
    }
}
