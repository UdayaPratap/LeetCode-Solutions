/*You are given an m x n binary matrix grid.

A move consists of choosing any row or column and toggling each value in that row or column (i.e., changing all 0's to 1's, and all 1's to 0's).

Every row of the matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.

Return the highest possible score after making any number of moves (including zero moves).
*/
class Solution {
    public int matrixScore(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        for(int i=0; i<m; i++){
            if(grid[i][0]==0) flipRow(grid, n, i);
        }
        for(int j=1; j<n; j++){
            int zeros=countZeros(grid, m, j);
            if(zeros> m/2) flipCol(grid, m, j);
        }

        //sum
        int sum=0; 
        for(int t[]: grid){
            int decimal = toDecimal(t);
            sum+=decimal;
        }
        return sum;
    }
    int toDecimal(int[] t){
        //CONVERTS BINARY ARRAY TO DECIMAL INT
        int decimal=0;
        for (int i = 0; i < t.length; i++) {
            decimal += t[i] * Math.pow(2, t.length - 1 - i);
            }
        return decimal;
    }
    int countZeros(int[][] grid, int m, int j){
        //COUNTS ZEROS IN JTH COLUMN
        int count=0;
        for(int i=0; i<m; i++){
            if(grid[i][j]==0) count++;
        }
        return count;
    }
    void flipRow(int[][] grid, int n, int i){
        // FLIPS ITH ROW
        for(int j=0; j<n; j++){
            if(grid[i][j]==1) grid[i][j]=0;
            else grid[i][j]=1;
        }
    }
    void flipCol(int[][] grid, int m, int j){
        // FLIPS JTH COLUMN
        for(int i=0; i<m; i++){
            if(grid[i][j]==1) grid[i][j]=0;
            else grid[i][j]=1;
        }
    }
}
