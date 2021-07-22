import java.util.*;

public class sort {


    public static void main(String[] args) {
        Integer[] arr = {13, 7, 6, 45, 21, 9, 2, 100};
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(arr));
        recsort(al);
        System.out.println(al);
    }

    private static void recsort(ArrayList<Integer> arr) {
        if(arr.size()==1){
            return;
        }
        int temp = arr.get(arr.size()-1);
        arr.remove(arr.size()-1);
        recsort(arr);
        insert(arr,temp);
    }

    private static void insert(ArrayList<Integer> arr, int temp) {
        if(arr.size()==0 || arr.get(arr.size()-1)<=temp){
            arr.add(temp);
            return;
        }
        int val = arr.get(arr.size()-1);
        arr.remove(arr.size()-1);
        insert(arr,temp);
        arr.add(val);
    }
}
