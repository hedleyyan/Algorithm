package unionfind;

public class WeightedQuickUnion extends AbstractUnionFind {
    
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
        
        cost += 2;
        if (sz[pRoot] < sz[qRoot]) {
            cost ++;
            id[pRoot] = qRoot;
            cost += 2;
            sz[qRoot] += sz[pRoot];
        } else {
            cost ++;
            id[qRoot] = pRoot;
            cost += 2;            
            sz[pRoot] += sz[qRoot];
        }
        count --;
    }

    @Override
    int find(int p) {
        while (id[p] != p) {
            p = id[p];
            cost += 2;
        }
        cost ++;
        return p;
    }
}
