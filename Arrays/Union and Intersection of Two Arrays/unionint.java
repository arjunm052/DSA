import java.util.*;

public class unionint {
    public static void main(String[] args) {
        int arr1[] = {7, 1, 5, 2, 3, 6};
        int arr2[] = {3, 8, 6, 20, 7};
        union(arr1, arr2);
        intersection(arr1, arr2);
    }

    public static void union(int[] arr1,int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            set.add(arr2[i]);
        }
        System.out.print("Union: ");
        for(int x: set){
            System.out.print(x+" ");
        }
        System.out.println();
    }

    public static void intersection(int[] arr1,int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        System.out.print("Intersection: ");
        for(int i=0;i<arr2.length;i++){
            if(set.contains(arr2[i])){
                System.out.print(arr2[i]+" ");
                set.remove(arr2[i]);
            }
        }
        System.out.println();

    }
}
