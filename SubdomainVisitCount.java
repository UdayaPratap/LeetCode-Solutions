/*
A website domain "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next level, we have "leetcode.com" and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.

A count-paired domain is a domain that has one of the two formats "rep d1.d2.d3" or "rep d1.d2" where rep is the number of visits to the domain and d1.d2.d3 is the domain itself.

For example, "9001 discuss.leetcode.com" is a count-paired domain that indicates that discuss.leetcode.com was visited 9001 times.
Given an array of count-paired domains cpdomains, return an array of the count-paired domains of each subdomain in the input. You may return the answer in any order.
*/
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map=new HashMap<>();
        for(String t: cpdomains){
            String arr[]=t.split(" ");
            int count=Integer.parseInt(arr[0]);
            List<String> domains=getDomains(arr[1]);
            for(String dom: domains){
                map.put(dom, map.getOrDefault(dom, 0)+count);
            }
        }
        List<String> ans=getOutputList(map);
        return ans;
    }
    List<String> getDomains(String t){
        List<String> ret=new ArrayList<>();
        ret.add(t);
        int n=t.length();
        for(int i=0; i<n; i++){
            if(t.charAt(i)=='.') ret.add(t.substring(i+1));
        }
        return ret;
    }
    List<String> getOutputList(Map<String, Integer> map){
        List<String> ret=new ArrayList<>();
        for(String t: map.keySet()){
            ret.add(map.get(t)+" "+t);
        }
        return ret;
    }
}
