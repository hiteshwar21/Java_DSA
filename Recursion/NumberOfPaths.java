package Recursion;

/*The problem is to count all the possible paths from top left to bottom right of an MxN matrix with the constraints that from each cell you can either move to right or down.

        Return answer modulo 10^9+7.*/
public class NumberOfPaths {
    public static void main(String[] args) {
        int row = 2;
        int column = 3;
        System.out.println(updateNumberOfPaths(row, column));
    }

    static int updateNumberOfPaths(int row, int column){
        if(row == 0 || column == 0){
            return 0;
        }
        if(row == 1 && column == 1){
            return 1;
        }
        return updateNumberOfPaths(row-1, column) + updateNumberOfPaths(row, column-1);
    }
}
