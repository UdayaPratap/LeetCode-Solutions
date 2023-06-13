/*
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
*/
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int t: asteroids){
            if(t>0 || st.size()==0) //positive(going right) wont collide with prev or there is no prev asteroids then push
            {
                st.push(t);
            }
            else{ //t going negative(left)
                while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(t)) st.pop(); //smaller +ves will be destroyed
                if(!st.isEmpty() && st.peek()==Math.abs(t)) st.pop(); //equal magnitude and opps direction both destroyed
                else if(st.isEmpty() || st.peek()<0) st.push(t);
            }
        }
        int[] ans=new int[st.size()];
        for(int i=st.size()-1; i>=0; i--) ans[i]=st.pop();
        return ans;
        
    }
}
