/*
You are given an array of strings equations that represent relationships between variables where each string equations[i] is of length 4 and takes one of two different forms: "xi==yi" or "xi!=yi".Here, xi and yi are lowercase letters (not necessarily different) that represent one-letter variable names.

Return true if it is possible to assign integers to variable names so as to satisfy all the given equations, or false otherwise.

 
 */
class Solution {
    public static int Find_par(int u, int[] par){
        if(par[u] == u){
            return u;
        }
        
        return par[u] = Find_par(par[u], par);
    }
    
    public boolean equationsPossible(String[] equations) {
        int[] par = new int[26];
        for(int i = 0; i < 26; i++){
            par[i] = i;
        }
        
        // Considering all Equal Equations
        for(String s : equations){
            char ch1 = s.charAt(0);
            char ch2 = s.charAt(1);
            char ch3 = s.charAt(3);
            
            int p1 = Find_par(ch1 - 'a', par);
            int p2 = Find_par(ch3 - 'a', par);
            
            if(ch2 == '=' && p1 != p2){
                par[p2] = p1;
            }
        }
        
        // Considering all Not Equal Equations
        for(String s : equations){
            char ch1 = s.charAt(0);
            char ch2 = s.charAt(1);
            char ch3 = s.charAt(3);
            
            int p1 = Find_par(ch1 - 'a', par);
            int p2 = Find_par(ch3 - 'a', par);
            
            if(ch2 == '!' && p1 == p2){
                return false;
            }
        }
        
        return true;
    }
    }
