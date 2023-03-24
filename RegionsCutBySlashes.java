/*
An n x n grid is composed of 1 x 1 squares where each 1 x 1 square consists of a '/', '\', or blank space ' '. These characters divide the square into contiguous regions.

Given the grid grid represented as a string array, return the number of regions.

Note that backslash characters are escaped, so a '\' is represented as '\\'.
*/
class Solution {
    int parent[];
    public int regionsBySlashes(String[] grid) {
       int n=grid.length;
       int N=n+1; //if n*n cells then n+1* n+1 dots to be connected

       int cycles=1; // square already present outer boundary, hence on cycle and one area
       parent=new int[N*N];
       for(int i=0; i<N*N; i++)
       {
          if (i / N == 0 || i % N == 0 || i / N == N - 1 || i % N == N - 1) { 
                parent[i] = 0;
            } else {
                parent[i] = i;
            }
       } 

       for(int i=0; i<n; i++)
       {
           String row=grid[i];
           for(int j=0; j<n; j++){
               if(row.charAt(j)=='/'){
                   //find ultimate parent of nodes joined by / to check if already having same parent.
                   //if same parent then cycle completed else set same parent.
                   int p1 = findParent(i * N + j + 1);
                    int p2 = findParent((i + 1) * N + j);
                   cycles+=join(p1, p2);
               }else if(row.charAt(j)=='\\'){{
                   int p1 = findParent(i * N + j);
                    int p2 = findParent((i + 1) * N + j+1);
                    cycles+=join(p1, p2);
               }}
           }
       }
       return cycles;
    }
    int findParent(int n){
        return parent[n]==n? n : (parent[n]=findParent(parent[n]));
    }
    int join(int p1, int p2)
    {
        if(parent[p1]==parent[p2])
            return 1; //1 cycle if already same parents
        parent[p1]=p2;
        return 0;

    }
}
