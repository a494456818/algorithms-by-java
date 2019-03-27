import basics.ReadGraph;
import basics.SparseGraph;

public class Main {

    // 测试无权图最短路径算法
    public static void main(String[] args) {

        String filename = "graph_file/testG1.txt";
        SparseGraph g = new SparseGraph(13, false);
        ReadGraph readGraph = new ReadGraph(g, filename);
        g.show();

        ShortestPath shortestPath = new ShortestPath(g, 5);
        shortestPath.showPath(3);
    }
}
