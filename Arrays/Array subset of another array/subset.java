import java.util.*;

public class subset {
    public static void main(String[] args) {
        int arr1[] = {10, 5, 2, 23, 19};
        int arr2[] =  {19, 5, 3};
        System.out.println(isSubset(arr1,arr2));
    }

    public static boolean isSubset(int[] arr1,int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr2.length;i++){
            set.add(arr2[i]);
        }

        for(int i=0;i<arr1.length;i++){
            if(set.contains(arr1[i])){
                set.remove(arr1[i]);
            }
        }

        if(set.size()==0){
            return true;
        }

        return false;
    }

}
