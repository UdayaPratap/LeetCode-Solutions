/*
You are given an m x n matrix of characters box representing a side-view of a box. Each cell of the box is one of the following:

A stone '#'
A stationary obstacle '*'
Empty '.'
The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.

It is guaranteed that each stone in box rests on an obstacle, another stone, or the bottom of the box.

Return an n x m matrix representing the box after the rotation described above.
*/
class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int row = box.length, col = box[0].length;
        char[][] res = new char[col][row];
        // move right then rotate
        for (int i = 0; i < row; i++) {
            for (int j = col-1; j >= 0; j--) {
                if (box[i][j] == '#') {
                    int curCol = j;
                    while (curCol+1 < col && box[i][curCol+1] == '.') {
                        curCol++;
                    }
                    if (curCol != j) {
                        box[i][curCol] = '#';
                        box[i][j] = '.';
                    }
                }
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[j][i] = box[row-1-i][j];
            }
        }
        return res;
    }
}
