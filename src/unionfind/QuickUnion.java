package unionfind;

public class QuickUnion extends UnionFind {

    public QuickUnion(int N) {
        super(N);
    }

    @Override
    void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        
        if (pRoot == qRoot) return;
        
        id[pRoot] = qRoot;
        count --;
    }

    @Override
    int find(int p) {
        while (id[p] != p) p = id[p];
        return p;
    }

}
