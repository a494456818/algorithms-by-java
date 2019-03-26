import basics.ReadGraph;
import basics.SparseGraph;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // 使用两种图的存储方式读取testG1.txt文件
        String filename = "graph_file/testG1.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1, filename);
        System.out.println("test G1 in Sparse Graph:");
        g1.show();

        Components components = new Components(g1);
        int v = 0;
        List<Integer> bfs = components.bfs(0);
        System.out.println("从顶点" + v + "出发时，广度优先遍历路径为：" + bfs.toString());
    }

}
