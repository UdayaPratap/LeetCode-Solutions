/*
Implement the LFUCache class:

LFUCache(int capacity) Initializes the object with the capacity of the data structure.
int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.

When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.

The functions get and put must each run in O(1) average time complexity.

 
 */
class LFUCache {
    Map<Integer, Node> map=new HashMap<>();
    PriorityQueue<Node> pq=new PriorityQueue<Node>(new freqComparator());
    int counter;
    int cap;
    public LFUCache(int capacity) {
        cap=capacity;
    }
    
    public int get(int key) {
        counter++;
        if(map.containsKey(key)){
            Node node=map.get(key);
            pq.remove(node);
            node.freq+=1;
            node.date=counter;
            pq.add(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        counter++;
        if(cap==0)
            return;
        Node node = map.get(key);
        if(node!=null){
            node.freq+=1;
            node.val =value;
            node.date = counter;
            pq.remove(node);
            pq.add(node);
            return;
        }
        if(cap==map.size()){
            map.remove(pq.poll().key);
        }
            node = new Node(key, value, 1, counter);
            map.put(key, node);
            pq.add(node);
        
    }
    class Node{
        int key;
        int val;
        int freq;
        int date;
        Node(int k, int v, int f, int d){
            key=k;
            val=v;
            freq=f;
            date=d;
        }
    }
    class freqComparator implements Comparator<Node>{
            public int compare(Node a, Node b){
                if(a.freq==b.freq){
                    if(a.date<b.date) return -1;
                    else if(a.date==b.date) return 0;
                    else return 1;
                }
                return a.freq-b.freq;
            }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
