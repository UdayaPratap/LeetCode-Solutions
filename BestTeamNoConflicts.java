/*
You are the manager of a basketball team. For the upcoming tournament, you want to choose the team with the highest overall score. The score of the team is the sum of scores of all the players in the team.

However, the basketball team is not allowed to have conflicts. A conflict exists if a younger player has a strictly higher score than an older player. A conflict does not occur between players of the same age.

Given two lists, scores and ages, where each scores[i] and ages[i] represents the score and age of the ith player, respectively, return the highest overall score of all possible basketball teams.

 */
class Solution {
    class Player{
        int age;
        int score;
        public Player(int age, int score) {
        this.age = age;
        this.score = score;
         }
    }
    int dp[][];
    public int bestTeamScore(int[] scores, int[] ages) {
        int n=scores.length;
        dp=new int[n+1][n+1];
        Player[] p=new Player[n];
        for(int i=0;i<n;i++)
        {
            p[i]=new Player(ages[i], scores[i]);
        }
        Arrays.sort(p, (a, b) -> a.age == b.age ? a.score - b.score : a.age - b.age);
        
        return helper(p, 0, -1);
        
    }
    
    int helper(Player[] players, int i,int prev)
    {
        if(i==players.length) return 0;
        if(prev!=-1 && dp[i][prev]!=0) return dp[i][prev];
        int noTake=helper(players, i+1, prev);
        int take=0;
        if(prev==-1) //first element
            take=helper(players, i+1, i)+players[i].score;

        //age>prevAge
        else if(players[i].age>players[prev].age && players[i].score>=players[prev].score)
             take=players[i].score+helper(players, i+1, i); 
        //ages equal
        else if(players[i].age==players[prev].age)
            take=players[i].score+helper(players, i+1, i);
        int ans=Math.max(take, noTake);
        if(prev!=-1) dp[i][prev]=ans;
        return ans;
        
    }
}
