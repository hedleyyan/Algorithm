package unionfind;

public class QuickUnionFind extends UnionFind {

    int branch;
    int[] id;
    
    public QuickUnionFind(int N) {
        super(N);
    }
    
    @Override
    public void union(int p, int q) {
        for (int i=0; i<id.length; i++) {
            if (id[i] == id[q]) { 
                id[i] = id[p];
            }
        }
    }

    @Override
    public int find(int p) {
        return id[p];
    }

}
