/*
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length, m=matrix[0].length;
        int first=0;
        int last=n-1;
        while(first<=last){
            int mid= first+(last-first)/2;
            if(target==matrix[mid][0]) return true;
            else if(target<matrix[mid][0]) last=mid-1;
            else{
                if(target==matrix[mid][m-1]) return true;
                if(binSearch(matrix[mid], target)) return true;
                first=mid+1;
            }
        }
        return false;
    }
    boolean binSearch(int[] arr, int target){
        int left=0, right=arr.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]==target) return true;
            else if(target<arr[mid]) right=mid-1;
            else left=mid+1;
        }
        return false;
    }
}
