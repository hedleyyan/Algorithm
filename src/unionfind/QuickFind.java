package unionfind;

public class QuickFind extends UnionFind {

    public QuickFind(int N) {
        super(N);
    }
    
    @Override
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        
        if (pID == qID) return;
        
        for (int i=0; i<id.length; i++) {
            cost ++;
            if (id[i] == pID) { 
                cost ++;
                id[i] = qID;
            }
        }
        count --;
    }

    @Override
    public int find(int p) {
        cost ++;
        return id[p];
    }

}
