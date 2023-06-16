/*

A cinema has n rows of seats, numbered from 1 to n and there are ten seats in each row, labelled from 1 to 10 as shown in the figure above.

Given the array reservedSeats containing the numbers of seats already reserved, for example, reservedSeats[i] = [3,8] means the seat located in row 3 and labelled with 8 is already reserved.

Return the maximum number of four-person groups you can assign on the cinema seats. A four-person group occupies four adjacent seats in one single row. Seats across an aisle (such as [3,3] and [3,4]) are not considered to be adjacent, but there is an exceptional case on which an aisle split a four-person group, in that case, the aisle split a four-person group in the middle, which means to have two people on each side.
*/
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int []t: reservedSeats){
            map.putIfAbsent(t[0],new ArrayList<>());
            map.get(t[0]).add(t[1]);
            
        }
        int total=2*(n - map.size()); //if there are no entries for a row out of n rows that means that row is empty and can accomodate 2 groups of 4
        for(int t: map.keySet()){
            List<Integer> row=map.get(t);
            boolean leftBlocked=false, rightBlocked=false, midBlocked=false;
            for(int seat: row){
                if(seat>=2 && seat<=5) leftBlocked=true;
                if(seat>=4 && seat<=7) midBlocked=true;
                if(seat>=6 && seat<=9) rightBlocked=true;

                if(leftBlocked && rightBlocked && midBlocked) break;
            }
            if(!leftBlocked) total++;
            if(!rightBlocked) total++;
            if(leftBlocked && rightBlocked && !midBlocked) total++;
        }
        return total;
    }
}
