import java.util.*;

public class tripletsum {
    public static void main(String[] args) {
        int[] arr = {1,2,45,6,10,8}; 
        System.out.println(findtrip(arr, 13));
    }

    public static boolean findtrip(int[] arr,int sum) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(set.contains(sum-arr[i]-arr[j])){
                    return true;
                }else{
                    set.add(arr[i]);
                }
            }
        }

        return false;
    }
}
