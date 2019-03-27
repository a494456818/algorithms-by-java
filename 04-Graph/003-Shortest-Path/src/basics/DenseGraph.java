package basics;

import java.util.Vector;

// 稠密图（邻接矩阵存储）
public class DenseGraph implements Graph {

    private int n; // 结点数
    private int m; // 边数
    private boolean directed; // 是否为有向图
    private boolean[][] g; // 图数据

    public DenseGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        // 初始化图
        g = new boolean[n][n];
    }

    @Override
    public int V() {
        return n;
    }

    @Override
    public int E() {
        return m;
    }

    @Override
    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        if (hasEdge(v, w))
            return;
        g[v][w] = true;
        if (!directed)
            g[w][v] = true;
        m++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w];
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(g[i][j] + "\t");
            System.out.println();
        }
    }

    @Override
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        Vector<Integer> adjV = new Vector<>();
        for (int i = 0; i < n; i++)
            if (g[v][i])
                adjV.add(i);
        return adjV;
    }
}