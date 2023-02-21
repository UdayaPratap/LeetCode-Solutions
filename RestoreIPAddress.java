/*
A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.
*/
class Solution {
    public List<String> restoreIpAddresses(String s) {
    List<String> res = new LinkedList<>();
    int[] segments= new int[4];
    helper(res, s, 0,  segments, 0);
    return res;
    }
    void helper(List<String> res, String s, int idx, int[] segments, int n  )// n is no. of dots
    {
        if(idx==s.length() && n==4)
        {
            res.add(segments[0]+"."+segments[1]+"."+segments[2]+"."+segments[3]);
            return;
        }else if(idx==s.length() || n==4) return;

        //make all possible segments for segment no. n
        for(int len = 1 ; len <= 3 && idx + len <= s.length() ; len ++)
        {
            int val = Integer.parseInt(s.substring(idx, idx + len));
            if((val>255) || (len>=2 && s.charAt(idx) == '0')) //leading zero or greater than 255
                break;

            segments[n]=val;
            helper(res, s, idx+len, segments, n+1);
            
            
        }
    }
}
