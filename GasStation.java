/*
There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique
*/
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int gasSum=0, costSum=0;
        for(int i=0; i<n; i++){
            gasSum+=gas[i]; 
            costSum+=cost[i];
        }
        if(gasSum<costSum) return -1; //impossible to complete a circle from any station
        //find starting index
        int total=0;
        int ans=0;
        for(int i=0; i<n; i++){
            total+=gas[i]-cost[i];
            if(total<0) //negative gas balance
            {
                total=0; //reset and try again for next index
                ans=i+1;
            }
        }
        return ans;
    }
   
}
