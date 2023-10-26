package Recursion;

/*Given a 2D screen arr[][] where each arr[i][j] is an integer representing the color of that pixel,
also given the location of a pixel (X, Y) and a color C, the task is to replace the color of the given pixel
and all the adjacent same-colored pixels with the given color.

        Example:
        Input: arr[][] = {
        {1, 1, 1, 1},
        {1, 1, 1, 1},
        {1, 0, 0, 1},
        {1, 2, 2, 2},
        {1, 1, 1, 2},
        {1, 1, 1, 2},
        {1, 1, 1, 1},
        {1, 1, 1, 1}}
        X = 4, Y = 4, C = 3
        Output:
        1 1 1 1
        1 1 1 1
        1 0 0 1
        1 3 3 3
        1 1 1 3
        1 1 1 3
        1 1 1 1
        1 1 1 1
        Explanation:
        The values in the given 2D screen indicate colors of the pixels. X and Y are coordinates of the brush,
        C is the color that should replace the previous color on screen[X][Y] and all surrounding pixels with the same color.
        Hence, all the 2 are replaced with 3.*/
public class FloodFill {
    public static void main(String args[]){
        int[][] screen = {
                {1, 2, 1, 1},
                {1, 1, 1, 1},
                {1, 0, 0, 1},
                {1, 2, 2, 2},
                {1, 1, 1, 2},
                {1, 1, 1, 2},
                {1, 1, 1, 1},
                {1, 1, 1, 1}};
        int x=3, y=3;
        int rowNum = screen.length;
        int colNum = screen[0].length;
        int currentColor = screen[x][y];
        int newColor = 3;
        floodFill(screen, x, y, rowNum, colNum, currentColor, newColor);
        System.out.println("FloodFill Done");
    }

    static void floodFill(int[][] screen, int sr, int sc, int rowNum, int colNum, int prevColor, int newColor){
        //Base Condition
        if(sr<0 || sc<0 || sr>=rowNum || sc>=colNum){
            return;
        }
        if(screen[sr][sc]!= prevColor){
            return;
        }

        screen[sr][sc] = newColor;

        //DFS
        floodFill(screen, sr-1, sc, rowNum, colNum, prevColor, newColor);
        floodFill(screen, sr+1, sc, rowNum, colNum, prevColor, newColor);
        floodFill(screen, sr, sc-1, rowNum, colNum, prevColor, newColor);
        floodFill(screen, sr, sc+1, rowNum, colNum, prevColor, newColor);
    }
}
