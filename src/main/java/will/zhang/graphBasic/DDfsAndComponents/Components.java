package will.zhang.graphBasic.DDfsAndComponents;

/**
 * Created by Will.Zhang on 2018/1/30 0030 16:52.
 * 求无权图的联通分量
 */
public class Components {

    /**
     * 图的引用
     */
    Graph g;
    /**
     * 记录dfs(deep first search)的过程中节点是否被访问
     */
    private boolean[] visited;
    /**
     * 记录联通分量个数
     */
    private int ccount;
    /**
     * 每个节点锁对应的联通分量标记
     */
    private int[] id;

    /**
     * 构造函数, 求出无权图的联通分量
     * @param graph
     */
    public Components(Graph graph) {
        //算法初始化
        this.g = graph;
        visited = new boolean[graph.V()];
        id = new int[graph.V()];
        ccount = 0;
        for (int i = 0; i < g.V(); i++) {
            visited[i] = false;
            id[i] = -1;
        }

        //求图联通分量
        for (int i = 0; i < g.V(); i++) {
            if(!visited[i]){
                dfs(i);
                ccount++;
            }
        }
    }

    /**
     * 返回图的联通分量个数
     * @return
     */
    int count(){
        return ccount;
    }

    /**
     * 查询点v和点w是否联通
     * @param v
     * @param w
     * @return
     */
    boolean isConnected(int v, int w){
        assert v >= 0 && v < g.V();
        assert w >= 0 && w < g.V();

        return id[v] == id[w];
    }

    /**
     * deep first search
     * 深度优先遍历
     * @param v
     */
    private void dfs(int v){

        visited[v] = true;
        id[v] = ccount;

        for (int i : g.adj(v)) {
            if(!visited[i]){
                dfs(i);
            }
        }
    }
}
