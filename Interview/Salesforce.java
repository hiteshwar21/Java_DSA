package Interview;

public class Salesforce {
    static int addNumbers(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;

        if(rowLength == 0 && colLength == 0){
            return 0;
        }
        //O(MN)
        for(int i =0;i<rowLength;i++){
            for(int j=0;j<colLength;j++){
                if(i==0 && j==0){
                    continue;
                } else if (i==0){
                    grid[0][j] = grid[0][j] + grid[0][j-1];
                } else if (j==0){
                    grid[i][0] = grid[i][0] + grid[i-1][0];
                } else {
                    grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
                }
            }
        }
        return grid[rowLength-1][colLength-1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[2][2];
        grid[0][0] = 1;
        grid[0][1] = 1;
        grid[1][0] = 3;
        grid[1][1] = 5;

        /*
        grid[0][2] = 4;

        grid[1][2] = 2;
        grid[2][0] = 1;
        grid[2][1] = 1;
        grid[2][2] = 4;*/

        int sum = addNumbers(grid);
        System.out.println(sum);
    }
}
