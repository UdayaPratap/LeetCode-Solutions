/*
There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).

You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial location.

Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.
*/
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int maxStops=1000;
        int[] n=new int[maxStops+1]; //denotes people in car at every stop
        int cap=capacity;
        for(int t[]: trips)
        {
            n[t[1]]=cap; //inc n when passengers get in car
            n[t[2]]=t[; //dec n when passengers get out
        }
        //at any point if n[i]>capacity => capacity insufficient, return false
        System.out.println(Arrays.toString(n));
        for(int t: n)
        {
            if(t>capacity) return false;
        }
        return true;

    }
}
