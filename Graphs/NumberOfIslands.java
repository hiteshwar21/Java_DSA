package Graphs;

/*Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's
        (water), return the number of islands.
        An island is surrounded by water and is formed by connecting adjacent lands
        horizontally or vertically. You may assume all four edges of the grid are all
        surrounded by water.
        Example 1
        Input: grid = [
        ["1","1","1","1","0"],
        ["1","1","0","1","0"],
        ["1","1","0","0","0"],
        ["0","0","0","0","0"]
        ]
        Output: 1
        Example 2
        Input: grid = [
        ["1","1","0","0","0"],
        ["1","1","0","0","0"],
        ["0","0","1","0","0"],
        ["0","0","0","1","1"]
        ]
        Output: 3*/
public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'0', '1', '0', '1'},
                {'1', '0', '1', '0'},
                {'0', '1', '1', '0'}
        };

        System.out.println(numIslands(grid));
    }

    private static int n;
    private static int m;
    static int numIslands(char[][] grid) {
        int count = 0;
        if(grid.length == 0){
            return 0;
        }
        n=grid.length;
        m=grid[0].length;
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    dfsCallBack(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfsCallBack(char[][] grid, int i, int j){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        dfsCallBack(grid,i+1,j);
        dfsCallBack(grid,i,j+1);
        dfsCallBack(grid,i-1,j);
        dfsCallBack(grid,i,j-1);
    }
}
