package unionfind;

public class WeightedQuickUnion extends UnionFind {
    
    int[] sz; 
    public WeightedQuickUnion(int N) {
        super(N);
        
        sz = new int[N];
        for (int i = 0; i < sz.length; i++) {
            sz[i] = 1;
        }
    }

    @Override
    void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        
        if (pRoot == qRoot) return;
        
        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        count --;
    }

    @Override
    int find(int p) {
        while (id[p] != p) p = id[p];
        return p;
    }
}
