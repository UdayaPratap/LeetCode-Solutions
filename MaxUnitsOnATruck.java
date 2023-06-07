/*
You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:

numberOfBoxesi is the number of boxes of type i.
numberOfUnitsPerBoxi is the number of units in each box of the type i.
You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.

Return the maximum total number of units that can be put on the truck.
*/
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b)->{ return b[1]-a[1]; });
        int units=0;
        for(int t[]: boxTypes){
            if(t[0]<=truckSize){
                units+=t[0]*t[1];
                truckSize-=t[0];
            }else{
                units+=truckSize*t[1];
                break;
            }
        }
        return units;
    }
    
}
