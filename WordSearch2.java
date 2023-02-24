/*
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
*/
 METHOD 1: TLE
 class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
        int n=board.length;
        int m=board[0].length;
        Set<String> ans = new HashSet<>();
        for(int i=0;i<n;i++)
            for(int j=0;j<m; j++)
                for(String word: words)
                    if(board[i][j]==word.charAt(0) && !ans.contains(word) && helper(i, j, board, 0, word, new boolean[n][m]))
                        ans.add(word);
        return new ArrayList<>(ans);
        

    }
    boolean helper(int i, int j, char[][] board, int idx, String word, boolean[][] visited)
    {
        if(word.length()==idx){
            
            return true;
        }
        int m=board.length; int n=board[0].length;
        if(i<0 || j<0 || i>=m || j>=n || visited[i][j] || board[i][j] != word.charAt(idx)) return false;

        visited[i][j]=true;
        //word found in any of 4 directions, return true
        if(//left 
        helper(i+1, j, board, idx+1, word, visited) ||
        //right
        helper(i-1, j, board, idx+1, word, visited) ||
        //up
        helper(i, j-1, board, idx+1, word, visited) ||
        //down
        helper(i, j+1, board, idx+1, word, visited) ) return true;
        visited[i][j]=false;
        return false;
    }
}

METHOD 2:
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int row = board.length;
        int col = board[0].length;
        
        boolean[][] visited = new boolean[row][col];
        Set<String> words_set = new HashSet<>();
        
        int max_len = 0;
        for(String w: words) {
            words_set.add(w);
            max_len = Math.max(max_len, w.length());
        }
        
        Set<String> ans = new HashSet<>(); //de-dup
        
        for(int i = 0; i < row; i++) 
            for(int j = 0; j < col; j++)
                helper(board, words_set, i, j, visited, new StringBuilder(), ans, 0, max_len);
        
        List<String> list = new ArrayList<String>();
        list.addAll(ans);
        return list;
    }
    
    private void helper(
        char[][] board, Set<String> words_set, int r, int c, boolean[][] visited, StringBuilder sb, Set<String> ans, int length, int max_len) {
        
        int row = board.length;
        int col = board[0].length;
        
        if (r < 0 || c < 0 || r == row || c == col) return;
        if (length >= max_len) return;
        if (visited[r][c]) return;
        
        visited[r][c] = true;
        sb.append(board[r][c]);
        
        if (words_set.contains(sb.toString()))
            ans.add(sb.toString());
        
        helper(board, words_set, r + 1, c, visited, sb, ans, length + 1, max_len);
        helper(board, words_set, r - 1, c, visited, sb, ans, length + 1, max_len);
        helper(board, words_set, r, c + 1, visited, sb, ans, length + 1, max_len);
        helper(board, words_set, r, c - 1, visited, sb, ans, length + 1, max_len);  
        
        visited[r][c] = false;
        sb.setLength(sb.length() - 1);
        
    }
}
