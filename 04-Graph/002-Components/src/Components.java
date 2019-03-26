import basics.Graph;

import java.util.*;

/**
 * 无权图操作：
 * 1. 求连通分量
 * 2. 从定点v开始广度优先遍历
 * 3. 从定点v开始深度优先遍历
 */
public class Components {

    Graph G;                    // 图的引用
    private boolean[] visited;  // 记录dfs的过程中节点是否被访问
    private int ccount;         // 记录连通分量个数
    private int[] id;           // 每个节点所对应的联通分量标记

    // 深度优先遍历
    private void dfs(int v) {
        visited[v] = true;
        id[v] = ccount;

        for (int i : G.adj(v)) {
            if (!visited[i])
                dfs(i);
        }
    }

    // 广度优先遍历
    public List<Integer> bfs(int v) {
        this.visited = new boolean[G.V()];
        Queue<Integer> queue = new LinkedList();
        List<Integer> ans = new ArrayList<>();
        visited[v] = true;
        queue.add(v);
        ans.add(v);
        while (!queue.isEmpty()) {
            int t = queue.poll();
            for (int i : G.adj(t))
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    ans.add(i);
                }
        }
        return ans;
    }

    public Components(Graph graph) {
        this.G = graph;
        visited = new boolean[G.V()];
        id = new int[G.V()];
        ccount = 0;
        for (int i = 0; i < G.V(); i++)
            id[i] = -1;
        // 求图的连通分量
        for (int i = 0; i < G.V(); i++) {
            if (!visited[i]) {
                dfs(i);
                ccount++;
            }
        }
    }

    int getCcount() {
        return ccount;
    }

    boolean isConnected(int v, int w) {
        assert v >= 0 && v < G.V();
        assert w >= 0 && w < G.V();
        return id[v] == id[w];
    }

}
