public class nearlySorted{
    public static int search(int[] arr,int n,int key){
      int start = 0;
      int end = n-1;
  
      while(start<=end){
        int mid = start+(end-start)/2;
        if(arr[mid]==key){
          return mid;
        }
        if(start<=mid-1 && arr[mid-1]==key){
          return mid-1;
        }
  
        if(end>=mid+1 && arr[mid+1]==key){
          return mid+1;
        }
  
        if(arr[mid]>key){
          end=mid-2;
        } else {
          start=mid+2;
        }
      }
  
      return -1;
      }
    public static void main(String[] args) {
   int arr[] = {10, 3, 40, 20, 50, 80, 70};
   int n = arr.length;
   int x = 70; 
   System.out.println(search(arr,n,x));
    }
}