/*
You are given a series of video clips from a sporting event that lasted time seconds. These video clips can be overlapping with each other and have varying lengths.

Each video clip is described by an array clips where clips[i] = [starti, endi] indicates that the ith clip started at starti and ended at endi.

We can cut these clips into segments freely.

For example, a clip [0, 7] can be cut into segments [0, 1] + [1, 3] + [3, 7].
Return the minimum number of clips needed so that we can cut the clips into segments that cover the entire sporting event [0, time]. If the task is impossible, return -1.

 */
class Solution {
    Integer[][] dp;
    public int videoStitching(int[][] clips, int time) {
        dp = new Integer[101][101];
        Arrays.sort(clips,(c1,c2)->c1[0]-c2[0]);
        int ans = (int)(1e5);
        
        for(int i=0;i<clips.length && clips[i][0]==0;i++)
            ans = Math.min(ans,f(i+1,clips[i][1],clips,time));
            
        if(ans == (int)(1e5)) return -1;
        return ans;
    }
    public int f(int j,int timeReached,int[][] clips,int time){
        if(timeReached>=time) return 1;
        if(j==clips.length){ 
            if(timeReached<time) return (int)(1e7);
            else return 1; 
        }
        if(dp[j][timeReached]!=null) return dp[j][timeReached];
        int ans =(int)(1e7);
        for(int k=j;k<clips.length;k++){
            if(clips[k][0]<=timeReached){
                int p = Math.max(clips[k][1],timeReached);
                ans = Math.min(ans,1+f(k+1,p,clips,time));   
            }
        }
        
        return dp[j][timeReached] = ans;
        
    }
    
    
}
