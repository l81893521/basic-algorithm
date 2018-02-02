package will.zhang.minimumSpanTree.BLazyPrim;

import java.util.Vector;

/**
 * Created by Will.Zhang on 2018/1/26 0026 18:16.
 * 稠密图 - 邻接矩阵
 */
public class DenseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {

    /**
     * 节点数
     */
    private int n;

    /**
     * 边数
     */
    private int m;

    /**
     * 是否为有向图
     */
    private boolean directed;

    /**
     * 图的具体数据
     */
    private Edge<Weight>[][] g;

    public DenseWeightedGraph(int n, boolean directed) {
        assert n > 0;

        this.n = n;
        //初始化没有边
        this.m = 0;
        this.directed = directed;
        //g初始化为n*n的布尔矩阵, 每一个g[i][j]均为false
        g = new Edge[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = null;
            }
        }
    }

    /**
     * 返回节点个数
     * @return
     */
    public int V(){
        return this.n;
    }

    /**
     * 返回边的个数
     * @return
     */
    public int E(){
        return m;
    }

    /**
     * 向图中添加一个边
     * @param e 边
     * */
    public void addEdge(Edge e){
        assert e.V() >= 0 && e.V() < n;
        assert e.W() >= 0 && e.W() < n;
        //如果有边则不需要添加
        // 当然也可以对重复的边进行其他方法的处理,例如覆盖掉旧的边
        if(hasEdge(e.V(), e.W())){
            return;
        }

        g[e.V()][e.W()] = new Edge(e);
        //如果是无向图
        if(!this.directed){
            g[e.W()][e.V()] = new Edge(e.W(), e.V(), e.wt());
        }
        //m代表边
        m++;
    }

    /**
     * 验证图中从v到w是否有边
     * @param v
     * @param w
     * @return
     */
    public boolean hasEdge(int v, int w){
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        return g[v][w] != null;
    }

    @Override
    public void show() {
        for( int i = 0 ; i < n ; i ++ ){
            for( int j = 0 ; j < n ; j ++ )
                if( g[i][j] != null )
                    System.out.print(g[i][j].wt()+"\t");
                else
                    System.out.print("NULL\t");
            System.out.println();
        }
    }

    /**
     * 返回图中一个顶点的所有邻边
     * @param v
     * @return
     */
    public Iterable<Edge<Weight>> adj(int v){
        assert v >= 0 && v < n;
        Vector<Edge<Weight>> adjV = new Vector<>();
        for (int i = 0; i < n; i++) {
            if(g[v][i] != null){
                adjV.add(g[v][i]);
            }
        }
        return adjV;
    }
}
