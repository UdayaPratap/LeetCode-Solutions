/*
Given a 2D matrix matrix, handle multiple queries of the following type:

Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
Implement the NumMatrix class:

NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
You must design an algorithm where sumRegion works on O(1) time complexity.
*/
class NumMatrix {
    int matrix[][];
    public NumMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        this.matrix = matrix;
        // col wise sum
        for(int i=1; i<r; i++)
        {
            for(int j=0; j<c; j++) matrix[i][j] = matrix[i][j] + matrix[i-1][j];
        }
        // row wise sum
        for(int i=0; i<r; i++)
        {
            for(int j=1; j<c; j++) matrix[i][j] = matrix[i][j] + matrix[i][j-1];
        }
        //matrix now contains preSum till 0
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total=matrix[row2][col2];
        int extra1=row1==0? 0 : matrix[row1-1][col2]; //unnecessary side area
        int extra2=col1==0? 0: matrix[row2][col1-1];  //unnecessary top area
        int common=(row1==0 || col1==0)? 0: matrix[row1-1][col1-1]; //common in both extra areas
        int ans=(total-extra1)-(extra2-common);
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
