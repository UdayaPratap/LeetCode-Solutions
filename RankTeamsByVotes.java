/*
In a special ranking system, each voter gives a rank from highest to lowest to all teams participating in the competition.

The ordering of teams is decided by who received the most position-one votes. If two or more teams tie in the first position, we consider the second position to resolve the conflict, if they tie again, we continue this process until the ties are resolved. If two or more teams are still tied after considering all positions, we rank them alphabetically based on their team letter.

You are given an array of strings votes which is the votes of all voters in the ranking systems. Sort all teams according to the ranking system described above.

Return a string of all teams sorted by the ranking system.
*/
class Solution {
    public String rankTeams(String[] votes) {
       int n=votes[0].length(); //no of individual candidates
       int[][] list=new int[26][n+1];
       for(int i=0; i<26; i++) list[i][n]=i; //to identify which candidate
       
       for(int i=0; i<votes.length; i++){
           String s=votes[i];
           for(int j=0; j<n; j++){
               list[s.charAt(j)-'A'][j]++;
           }
       }
       Arrays.sort(list, (a,b)->{
           for(int i=0; i<n; i++){
               if(a[i]<b[i]) return 1;
               if(a[i]>b[i]) return -1;
           }
           return 0;
       });
       StringBuilder sb=new StringBuilder();
       for(int i=0; i<n;i++){
           sb.append((char)('A'+list[i][n]));
       }
       return sb.toString();


    }

    
}
