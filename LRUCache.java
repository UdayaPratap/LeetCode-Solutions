/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.
*/
class LRUCache {
    HashMap<Integer, Node> map=new HashMap<>();
    Node head=new Node(0,0);
    Node tail=new Node(0,0);
    int cap;
    public LRUCache(int capacity) {
        cap=capacity;
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        if(map.containsKey(key))
        {
            Node temp=map.get(key);
            remove(temp);
            add(temp);
            return temp.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size()==cap){
            remove(tail.prev);
        }
        add(new Node(key, value));
    }
    private void add(Node node)
    {
        map.put(node.key, node);
        Node headNext=head.next;
        node.next=headNext;
        head.next=node;
        headNext.prev=node;
        node.prev=head;
    }
    private void remove(Node node){
        map.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    class Node{
        Node prev,next;
        int key, val;
        Node(int k, int v){
            key=k;
            val=v;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
