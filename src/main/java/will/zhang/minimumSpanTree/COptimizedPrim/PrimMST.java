package will.zhang.minimumSpanTree.COptimizedPrim;

import java.util.Vector;

/**
 * Created by Will.Zhang on 2018/2/5 0005 11:50.
 */
public class PrimMST<Weight extends Number & Comparable> {

    /**
     * 图的引用
     */
    private WeightedGraph g;
    /**
     * 最小索引堆, 算法辅助数据结构
     */
    private IndexMinHeap<Weight> ipq;
    /**
     * 访问的点所对应的边, 算法辅助数据结构
     */
    private Edge<Weight> [] edgeTo;
    /**
     * 标记数组, 在算法运行过程中标记节点i是否被访问
     */
    private boolean[] marked;
    /**
     * 最小生成树所包含的所有边
     */
    private Vector<Edge<Weight>> mst;
    /**
     * 最小生成树的权值
     */
    private Number mstWeight;

    public PrimMST(WeightedGraph graph){
        g = graph;
        assert (graph.E() >= 1);
        ipq = new IndexMinHeap<Weight>(graph.V());

        //算法初始化
        marked = new boolean[g.V()];
        edgeTo = new Edge[g.V()];
        for (int i = 0; i < g.V(); i++) {
            marked[i] = false;
            edgeTo[i] = null;
        }
        mst = new Vector<>();

        //prim
        visit(0);
        while(!ipq.isEmpty()){
            //使用最小索引堆找出已经访问的边中权值最小的边
            //最小索引堆中存储的点是索引, 通过点的索引找到对应的边
            int v = ipq.extractMinIndex();
            assert (edgeTo[v] != null);
            mst.add(edgeTo[v]);
            visit(v);
        }
        //计算最小生成树的权值
        mstWeight = mst.elementAt(0).wt();
        for (int i = 1; i < mst.size(); i++) {
            mstWeight = mstWeight.doubleValue() + mst.elementAt(i).wt().doubleValue();
        }

    }

    // 返回最小生成树的所有边
    Vector<Edge<Weight>> mstEdges(){
        return mst;
    }

    // 返回最小生成树的权值
    Number result(){
        return mstWeight;
    }

    void visit(int v) {
        assert !marked[v];

        marked[v] = true;
        //将和节点v相连接的为访问的另一端点, 和与之相连的边, 放入最小堆中
        for (Object item : g.adj(v)) {
            Edge<Weight> e = (Edge<Weight>) item;
            int w = e.other(v);
            //如果边的另一断点未被访问
            if(!marked[w]){
                //如果从没有考虑过这个断点, 直接将这个端点和与之相连接的边加入索引堆
                if(edgeTo[w] == null){
                    edgeTo[w] = e;
                    ipq.insert(w, e.wt());
                }else if(e.wt().compareTo(edgeTo[w].wt()) < 0){
                    edgeTo[w] = e;
                    ipq.change(w, e.wt());
                }
            }
        }
    }

    public static void main(String[] args) {
        String filename = PrimMST.class.getClass().getResource("/graph").getPath() + "/testG3.txt";
        int V = 8;

        DenseWeightedGraph denseWeightedGraph = new DenseWeightedGraph(V, false);
        ReadWeightedGraph readWeightedGraph = new ReadWeightedGraph(denseWeightedGraph, filename);

        // Test Prim MST
        System.out.println("Test Prim MST:");
        PrimMST<Double> primMST = new PrimMST<Double>(denseWeightedGraph);
        Vector<Edge<Double>> mst = primMST.mstEdges();
        for( int i = 0 ; i < mst.size() ; i ++ )
            System.out.println(mst.elementAt(i));
        System.out.println("The MST weight is: " + primMST.result());

        System.out.println();
    }
}
