import java.util.Vector;

public class SparseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {

    private int n; // 节点数
    private int m; // 边数
    private boolean directed; // 是否为有向图
    private Vector<Edge<Weight>>[] g;

    public SparseWeightedGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new Vector[n];
        for (int i = 0; i < n; i++)
            g[i] = new Vector<>();
    }

    // 返回节点个数
    @Override
    public int V() {
        return n;
    }

    // 返回边数
    @Override
    public int E() {
        return m;
    }

    // 向有向图添加一条边，权重为weight
    @Override
    public void addEdge(Edge e) {

        assert e.v() >= 0 && e.v() < n;
        assert e.w() >= 0 && e.w() < n;

        // 注意, 由于在邻接表的情况, 查找是否有重边需要遍历整个链表
        // 我们的程序允许重边的出现

        g[e.v()].add(new Edge(e));
        if (e.v() != e.w() && !directed)
            g[e.w()].add(new Edge(e.w(), e.v(), e.wt()));
    }

    // v到w是否有边
    @Override
    public boolean hasEdge(int v, int w) {

        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        for (Edge<Weight> e : g[v])
            if (e.other(v) == w)
                return true;
        return false;
    }

    // 查看图的信息
    @Override
    public void show() {

        for (int i = 0; i < n; i++) {
            System.out.print("vertex " + i + ":\t");
            for (int j = 0; j < g[i].size(); j++) {
                Edge e = g[i].elementAt(j);
                System.out.print("( to:" + e.other(i) + ",wt:" + e.wt() + ")\t");
            }
            System.out.println();
        }

    }

    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }
}
