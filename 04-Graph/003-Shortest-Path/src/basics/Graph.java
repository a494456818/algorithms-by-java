package basics;

// 图的接口
public interface Graph {

    public int V(); // 返回图的结点树

    public int E(); // 返回边的数量

    public void addEdge(int v, int w); // 添加一条边

    boolean hasEdge(int v, int w); // 是否存在v->w的边

    void show(); // 显示图的信息

    public Iterable<Integer> adj(int v); // 返回图中一个顶点的所有邻边

}
