import java.util.*;

public class zerosum {
    public static void main(String[] args) {
        int[] arr = {-3, 2, 3, 1, 6};
        System.out.println(zerosub(arr));
    }

    public static boolean zerosub(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        for(int x: arr){
            sum+=x;
            if(set.contains(sum)){
                return true;
            }
            else if(sum==0){
                return true;
            }
            else{
                set.add(sum);
            }
        }
        return false;
    }
}
