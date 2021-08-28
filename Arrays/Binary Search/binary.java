public class binary {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 7, 13, 17, 25 };
        int n = 178;
        System.out.println(search(arr, n));
    }

    public static int search(int[] arr, int key) {
        int ans = -1;
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == key) {
                ans = mid;
                break;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}