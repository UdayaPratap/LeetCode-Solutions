/*
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
*/
class Solution {
    public double myPow(double x, int n){
        if(n<0){
        x=1/x;  
        }
        return helper(x, n);
    }
    public double helper(double x, int n) {
        if(n==0 || x==1) return 1;
        if(x==0) return 0;
        if(n==1) return x;
        double a=helper(x, n/2);
        if(n%2==0)
            return a*a;
        return a*a*x;
    }
}
