/*
You are given an integer array arr. Sort the integers in the array in ascending order by the number of 1's in their binary representation and in case of two or more integers have the same number of 1's you have to sort them in ascending order.

Return the array after sorting it.
*/
class Solution {
    public int[] sortByBits(int[] arr) {
        customSort(arr, 0, arr.length-1);
        return arr;
    }
    void customSort(int[] arr, int l, int r){
        if(l>=r) return;
        int mid=l+(r-l)/2;
        customSort(arr, l, mid);
        customSort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }
    void merge(int arr[], int l, int mid, int r){
        int[] ans=new int[r-l+1];
        int i=l, j=mid+1, ptr=0;
        while(i<=mid && j<=r){
            if(comparator(arr[i], arr[j])<0){
                ans[ptr++]=arr[i++];
            }else{
                ans[ptr++]=arr[j++];
            }
        }
        while(i<=mid) ans[ptr++]=arr[i++];
        while(j<=r) ans[ptr++]=arr[j++];
        System.arraycopy(ans, 0, arr, l, ans.length);
    }
    int comparator(int a, int b){
        int bitDiff=Integer.bitCount(a)-Integer.bitCount(b);
        if(bitDiff!=0) return bitDiff;
        return a-b;
    }
}
