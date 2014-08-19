package unionfind;

public class WeightedQuickUnionByHeight extends AbstractUnionFind {
    
    int[] h; 
    public WeightedQuickUnionByHeight(int N) {
        super(N);
        
        h = new int[N];
        for (int i = 0; i < h.length; i++) {
            h[i] = 1;
        }
    }

    @Override
    void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        
        if (pRoot == qRoot) return;
        
        cost += 2;
        if (h[pRoot] < h[qRoot]) {
            cost ++;
            id[pRoot] = qRoot;
            cost += 2;
            h[qRoot] = Math.min(h[pRoot] + 1, qRoot);
        } else {
            cost ++;
            id[qRoot] = pRoot;
            cost += 2;            
            h[pRoot] = Math.min(h[qRoot] + 1, pRoot);
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
