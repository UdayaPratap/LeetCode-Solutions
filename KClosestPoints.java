/*
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
*/
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int []b){ 
                double d1=Math.pow(a[0],2)+Math.pow(a[1],2);
                double d2=Math.pow(b[0],2)+Math.pow(b[1],2);
                return d1>d2? 1: -1;            }
        });
        for(int[] t: points) pq.add(t);
        int[][] ans=new int[k][2];
        for(int i=0; i<k; i++){
            ans[i]=pq.poll();
        }
        return ans;
    }
}
