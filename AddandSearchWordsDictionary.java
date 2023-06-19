/*Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 
 */
class WordDictionary {
    class TrieNode{
        boolean end;
        TrieNode[] children=new TrieNode[26];
    }
    TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }
    
    public void addWord(String word) {
       TrieNode current=root;
       for(char c: word.toCharArray()){
           TrieNode node=current.children[c-'a'];
           if(node==null){
               node=new TrieNode();
               current.children[c-'a']=node;
           }
           current=node;
       }
       current.end=true;
    }
    
    public boolean search(String word) {
        return helper(0, root, word.toCharArray());
    }
    boolean helper(int idx, TrieNode root, char[] word){
        if(idx==word.length){
            if(root.end) return true;
            return false;
        }
        char c=word[idx];
        if(c!='.'){
            TrieNode node=root.children[c-'a'];
            return (node!=null && helper(idx+1, node, word));
        }
        //c==.
        for(int i=0; i<root.children.length; i++){
            TrieNode node=root.children[i];
            if(node!=null){
                if(helper(idx+1, node, word)) return true;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
