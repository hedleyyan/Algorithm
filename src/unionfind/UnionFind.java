
package unionfind;

import java.lang.reflect.Constructor;
import java.net.URL;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;

public abstract class UnionFind {

    protected int count;

    protected int[] id;

    public UnionFind(int N) {
        this.count = N;
        this.id = new int[N];
        for (int i = 0; i < N; i++) {
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

    /**
     * 测试中等大小输入数据（625节点，900边）图形结果. 
     */
    public static void testMediumDraw(Class <? extends UnionFind> c) throws Exception {
        In in = new In(new URL("http://algs4.cs.princeton.edu/15uf/mediumUF.txt"));
//        In in = new In(new URL("http://algs4.cs.princeton.edu/15uf/largeUF.txt"));

        int N = in.readInt();

        // 初始化幕布大小
        int root = (int)Math.sqrt(N);
        StdDraw.setXscale(0, root);
        StdDraw.setYscale(0, root);

        // 反射调用带参数的构造型
        Constructor<? extends UnionFind> cons = c.getDeclaredConstructor(int.class);
        UnionFind uf = cons.newInstance(N);

        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            if (uf.connected(p, q))
                continue;
            uf.union(p, q);

            int px = p % root;
            int py = p / root;
            int qx = q % root;
            int qy = q / root;

            StdDraw.line(px, py, qx, qy);
            StdOut.println(p + " " + q);
        }

        StdOut.println(uf.count() + " components");
    }

    public static void main(String[] args) throws Exception {
        testMediumDraw(QuickUnion.class);
    }
}
