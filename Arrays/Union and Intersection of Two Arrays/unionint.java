import java.util.*;

public class unionint {
    public static void main(String[] args) {
        int arr1[] = { 7, 1, 5, 2, 3, 6 };
        int arr2[] = { 3, 8, 6, 20, 7 };
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        // unionSpace(arr1, arr2);
        intersectionSpace(arr1, arr2);
    }

    public static void union(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        System.out.print("Union: ");
        for (int x : set) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void unionSpace(int[] a, int[] b) {
        System.out.println("Union of Two Arrays: ");
        int i = 0, j = 0;
        int n = a.length, m = b.length;
        while (i < n && j < m) {
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }

            if (j > 0 && b[j] == b[j - 1]) {
                j++;
                continue;
            }

            if (a[i] < b[j]) {
                System.out.print(a[i] + " ");
                i++;
            } else if (b[j] < a[i]) {
                System.out.print(b[j] + " ");
                j++;
            } else {
                System.out.print(a[i] + " ");
                i++;
                j++;
            }
        }

        while (i < n) {
            System.out.print(a[i] + " ");
            i++;
        }

        while (j < m) {
            System.out.print(b[j] + " ");
            j++;
        }
    }

    public static void intersection(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        System.out.print("Intersection: ");
        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i])) {
                System.out.print(arr2[i] + " ");
                set.remove(arr2[i]);
            }
        }
        System.out.println();

    }

    public static void intersectionSpace(int[] a, int[] b) {
        int i = 0, j = 0;
        int n = a.length, m = b.length;
        while (i < n && j < m) {
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            } else if (a[i] < b[j]) {
                i++;
            } else if (b[j] < a[i]) {
                j++;
            } else {
                System.out.print(a[i] + " ");
                i++;
                j++;
            }
        }
    }
}
