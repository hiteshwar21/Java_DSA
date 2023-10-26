package MockPractise.Arrays;

/*Given a boolean matrix of size RxC where each cell contains either 0 or 1, modify it such that if a matrix cell matrix[i][j] is 1
    then all the cells in its ith row and jth column will become 1.

        Example 1:

        Input:
        matrix[][] = {{1, 0},
                      {0, 0}}
        Output:
        1 1
        1 0*/
public class BooleanMatrix {
    static void printMatrix(int mat[][])
    {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println("");
        }
    }

    public static void main(String args[]){
        int[][] matrix = {  { 1, 0, 0, 1 },
                            { 0, 0, 1, 0 },
                            { 0, 0, 0, 0 } };
        makeBooleanMatrix(matrix);
        printMatrix(matrix);
    }

    static void makeBooleanMatrix(int[][] matrix){
        boolean rowFlag = false, colFlag = false;

        //Setting up rowFlag, colFlag and FirstRow and FirstCol for update
        for(int i=0; i< matrix.length; i++){
            for(int j=0; j< matrix[0].length; j++){
                if(i==0 && matrix[i][j] == 1){
                    rowFlag = true;
                }

                if(j==0 && matrix[i][j] == 1){
                    colFlag = true;
                }

                if(matrix[i][j] == 1){
                    matrix[0][j] = 1;
                    matrix[i][0] = 1;
                }
            }
        }

        //based on FirstRow and FirstCol, updating the rest of matrix
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[0][j] == 1 || matrix[i][0] == 1){
                    matrix[i][j] = 1;
                }
            }
        }

        if(rowFlag == true){
            for(int j=0; j<matrix[0].length; j++){
                matrix[0][j] = 1;
            }
        }

        if(colFlag == true){
            for(int i=0; i< matrix.length; i++){
                matrix[i][0] = 1;
            }
        }

    }
}
