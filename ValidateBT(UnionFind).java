/*
You have n binary tree nodes numbered from 0 to n - 1 where node i has two children leftChild[i] and rightChild[i], return true if and only if all the given nodes form exactly one valid binary tree.

If node i has no left child then leftChild[i] will equal -1, similarly for the right child.

Note that the nodes have no values and that we only use the node numbers in this problem.
*/
class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        UnionFind uf=new UnionFind(n);
        for(int i=0; i<n;i++){
            if(leftChild[i]>=0 && !uf.union(i, leftChild[i])) return false;

            if(rightChild[i]>=0 && !uf.union(i, rightChild[i])) return false;
        }
        return uf.components()==1;
    }
    
}

class UnionFind{
    private int n;
    private int roots[];
    private int components;
    UnionFind(int n){
        this.n=n;
        roots=new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        components=n;
    }
    public boolean union(int parent, int child){
        int rootOfParent=findRoot(parent);
        int rootOfChild=findRoot(child);
        if(rootOfParent==rootOfChild ||  rootOfChild!=child) return false;

        roots[rootOfChild]=rootOfParent;
        components--;
        return true;
    }
    private int findRoot(int v){
        while(v!=roots[v]){
            roots[v]=roots[roots[v]];
            v=roots[v];
        }
        return v;

    }
    public int components(){
        return components;
    }
}
