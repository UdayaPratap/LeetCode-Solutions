/*
There are n soldiers standing in a line. Each soldier is assigned a unique rating value.

You have to form a team of 3 soldiers amongst them under the following rules:

Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
A team is valid if: (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).
*/
class Solution {
    public int numTeams(int[] rating) {
        int n=rating.length, ans=0;
        for(int j=1; j<n-1; j++)
        {
            int leftInc=0 /*inc order to left*/, leftDec=0 /*dec order to left*/;
            int rightInc=0/*inc order to right*/, rightDec=0/*dec order to right*/;
            for(int i=0; i<j; i++){
                if(rating[i]<rating[j]) leftInc++;
                else leftDec++;
            }
            for(int k=j+1; k<n; k++)
            {
                if(rating[j]<rating[k]) rightInc++;
                else rightDec++;
            }
            ans+=(leftInc*rightInc)/*total inc teams*/+(leftDec*rightDec)/*total dec teams*/;
        }
        return ans;
    }
}
