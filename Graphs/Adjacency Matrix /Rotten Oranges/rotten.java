import java.util.*;

public class rotten {

    static class Pair {
        int time;
        int x;
        int y;

        Pair(int time, int x, int y) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(0, i, j));
                }
            }
        }

        int lastTime = 0;
        while (!q.isEmpty()) {
            Pair rem = q.poll();
            lastTime = rem.time;

            if (isSafe(grid, rem.x - 1, rem.y)) {
                grid[rem.x - 1][rem.y] = 2;
                q.add(new Pair(rem.time + 1, rem.x - 1, rem.y));
            }
            if (isSafe(grid, rem.x + 1, rem.y)) {
                grid[rem.x + 1][rem.y] = 2;
                q.add(new Pair(rem.time + 1, rem.x + 1, rem.y));
            }
            if (isSafe(grid, rem.x, rem.y - 1)) {
                grid[rem.x][rem.y - 1] = 2;
                q.add(new Pair(rem.time + 1, rem.x, rem.y - 1));
            }
            if (isSafe(grid, rem.x, rem.y + 1)) {
                grid[rem.x][rem.y + 1] = 2;
                q.add(new Pair(rem.time + 1, rem.x, rem.y + 1));
            }

        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }

        }

        return lastTime;

    }

    public static boolean isSafe(int grid[][], int x, int y) {
        return (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length && grid[x][y] == 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the order of matrix: ");
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println("Enter the matrix: ");
        int[][] grid = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        sc.close();
        System.out.println(orangesRotting(grid));
    }

}
