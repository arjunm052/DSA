/*
The N Queen is the problem of placing N chess queens on an N×N chessboard so that no 
two queens attack each other. 
*/

import java.util.*;

public class solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of Board: ");
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        solveNQueen(board,0);
    }

    public static void solveNQueen(int[][] board,int row) {
        if(row==board.length){
            printBoard(board);
            return;
        }

        for(int col=0;col<board[0].length;col++){
            
            if(isSafe(board,row,col)){
                board[row][col]=1;
                solveNQueen(board, row+1);
                board[row][col]=0;
            }
            
        }
    }

    public static boolean isSafe(int[][] board,int row,int col) {
        for(int i=row,j=col;i>=0;i--){
            if(board[i][j]==1){
                return false;
            }
        }
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j]==1){
                return false;
            }
        }

        for(int i=row,j=col;i>=0 && j<board[0].length;i--,j++){
            if(board[i][j]==1){
                return false;
            }
        }


        return true;
    }

    public static void printBoard(int[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}