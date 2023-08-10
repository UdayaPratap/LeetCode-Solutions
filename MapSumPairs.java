/*
Design a map that allows you to do the following:

Maps a string key to a given value.
Returns the sum of the values that have a key with a prefix equal to a given string.
Implement the MapSum class:

MapSum() Initializes the MapSum object.
void insert(String key, int val) Inserts the key-val pair into the map. If the key already existed, the original key-value pair will be overridden to the new one.
int sum(string prefix) Returns the sum of all the pairs' value whose key starts with the prefix.
  */
class MapSum {
    Map<String, Integer> map;
    public MapSum() {
       map=new HashMap<>(); 
    }
    
    public void insert(String key, int val) {
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        int n=prefix.length();
        int hash=getHash(prefix);
        int sum=0;
        for(String s: map.keySet()){
            if(s.length()<n) continue;
            if(getHash(s.substring(0,n))==hash) sum+=map.get(s);
        }
        return sum;
    }
    private int getHash(String s){
        int h=0;
        
        for(char c: s.toCharArray()) h=h*10+(int)c;
        return h;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
