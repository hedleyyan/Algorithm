
package unionfind;

//import java.awt.Font;
import java.io.File;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;

public abstract class UnionFind {

    protected int count;

    protected int[] id;
    
    // the number of array access
    protected int cost;

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
        
        StdDraw.setPenRadius(0.01);
        for (int i=0; i<root; i++) {
            for (int j=0; j<root; j++) {
                StdDraw.point(i, j);
            }
        }
        StdDraw.setPenRadius();
        
//        StdDraw.setFont(new Font("hi", 1, 8));
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
            
//            StdDraw.textLeft(px, py, p + "");
//            StdDraw.textLeft(qx, qy, q + "");
            StdDraw.line(px, py, qx, qy);
            StdOut.println(p + " " + q);
        }
        
        StdDraw.textRight(root, root, uf.count() + " components");
        StdOut.println(uf.count() + " components");
    }

    /**
     * 均摊分析. 
     */
    private static void amortizedCostPlots(Class <? extends UnionFind> c) throws Exception {
        In in = new In(new File("data/mediumUF.txt"));
        int N = in.readInt();
        
        // 反射调用带参数的构造型
        Constructor<? extends UnionFind> cons = c.getDeclaredConstructor(int.class);
        UnionFind uf = cons.newInstance(N);
        
        
        // 存储每次的消耗和平均消耗值
        Map<Integer, Integer> i2SingleCost = new HashMap<Integer, Integer>();
        Map<Integer, Integer> i2AvgCost = new HashMap<Integer, Integer>();
        
        int i = 0;
        long start = System.currentTimeMillis();
        while (!in.isEmpty()) {
            // 进行这次处理之前的总cost
            int lastCost = uf.cost;
            
            int p = in.readInt();
            int q = in.readInt();
            if (uf.connected(p, q)) {
            } else {
                uf.union(p, q);
            }
            
            i2SingleCost.put(++i, uf.cost - lastCost);
            i2AvgCost.put(i, uf.cost / i);
        }
        long costTime = System.currentTimeMillis() - start;
        
        // 初始化幕布大小
        int xscale = Collections.max(i2SingleCost.keySet());
        int yscale = Collections.max(i2SingleCost.values());
        StdDraw.setXscale(-20, xscale);
        StdDraw.setYscale(0, yscale);
        
        // 描坐标
        StdDraw.line(0, 0, xscale, 0);
        StdDraw.line(0, 0, 0, yscale);

        for (int y = 0, flag = 12; y < yscale; y += yscale/Math.max(flag--, 2)) {
            StdDraw.line(0, y, 10, y);
            StdDraw.text(-40, y, y + "");
        }
        
        // TITLE
        String info = String.format("Avg Cost:%.2f  Time cost:%d", uf.cost / (float)xscale, costTime);
        StdDraw.text(xscale / 2, yscale, info);
        
        // 描分布点
        for (Integer iKey : i2SingleCost.keySet()) {
            StdDraw.setPenColor();
            StdDraw.point(iKey, i2SingleCost.get(iKey));
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.point(iKey, i2AvgCost.get(iKey));
        }
        
    }
    
    public static void main(String[] args) throws Exception {
//        testMediumDraw(WeightedQuickUnion.class);
        amortizedCostPlots(WeightedQuickUnionByHeight.class);
    }
    
}
