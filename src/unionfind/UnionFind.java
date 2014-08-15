
package unionfind;


public abstract class UnionFind {
    
    protected int count;
    protected int[] id;
    
    public UnionFind(int N) {
        this.count = N;
        this.id = new int[N];
        for (int i=0; i<N; i++) {
            this.id[i] = i;
        }
    }
    
    abstract void union(int p, int q);
    abstract int find(int p);
    
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    
    public int count() {
        return this.count;
    }
    
    public static void test (Class<? extends UnionFind> c) {
       
    }
}
