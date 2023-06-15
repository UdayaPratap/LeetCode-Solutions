/*
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
*/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words=new HashSet<>(wordList);
        Set<String> vis=new HashSet<>();
        if(!words.contains(endWord)) return 0;
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        int ans=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0; i<size; i++){
                String t=q.poll();
                if(t.equals(endWord)) return ans;

                for(int j=0; j<t.length(); j++){
                    for(int k='a'; k<='z'; k++){
                        char arr[]=t.toCharArray();
                        arr[j]=(char)k;
                        String str=new String(arr);
                        if(words.contains(str) && !vis.contains(str)){
                            vis.add(str);
                            q.add(str);
                        }
                    }
                }
            }
            ans++;
        }
        return 0;
    }
}
