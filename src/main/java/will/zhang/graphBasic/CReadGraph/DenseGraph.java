package will.zhang.graphBasic.CReadGraph;

import java.util.Vector;

/**
 * Created by Will.Zhang on 2018/1/26 0026 18:16.
 * 稠密图 - 邻接矩阵
 */
public class DenseGraph implements Graph{

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
    private boolean[][] g;

    public DenseGraph(int n, boolean directed) {
        assert n > 0;

        this.n = n;
        //初始化没有边
        this.m = 0;
        this.directed = directed;
        //g初始化为n*n的布尔矩阵, 每一个g[i][j]均为false
        g = new boolean[n][n];
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
     * 想图中添加一个边
     * @param v 一个点
     * @param w 另一个点
     */
    public void addEdge(int v, int w){
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        //如果有边则不需要添加
        if(hasEdge(v, w)){
            return;
        }

        g[v][w] = true;
        //如果是无向图
        if(!this.directed){
            g[w][v] = true;
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

        return g[v][w];
    }

    @Override
    public void show() {
        for( int i = 0 ; i < n ; i ++ ){
            for( int j = 0 ; j < n ; j ++ )
                System.out.print(g[i][j]+"\t");
            System.out.println();
        }
    }

    /**
     * 返回图中一个顶点的所有邻边
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v){
        assert v >= 0 && v < n;
        Vector<Integer> adjV = new Vector<>();
        for (int i = 0; i < n; i++) {
            if(g[v][i]){
                adjV.add(i);
            }
        }
        return adjV;
    }
}
