package will.zhang.minimumSpanTree.DKruskalAlgorithm;


import java.util.Vector;

/**
 * Created by Will.Zhang on 2018/2/1 0001 18:45.
 * 最小生成树(Minimum Spinning Tree)
 * 使用Lazy Prim算法
 */
public class LazyPrimMST<Weight extends Number & Comparable> {

    /**
     * 图的引用
     */
    private WeightedGraph<Weight> g;
    /**
     * 最小堆, 算法辅助数据结构
     */
    private MinHeap<Edge<Weight>> pq;
    /**
     * 数据标记, 在算法运行过程中标记节点i是否被访问
     */
    private boolean[] marked;
    /**
     * 最小生成树包含的所有边
     */
    private Vector<Edge<Weight>> mst;
    /**
     * 最小生成树的权值
     */
    private Number mstWeight;

    public LazyPrimMST(WeightedGraph<Weight> graph){
        this.g = graph;
        pq = new MinHeap<>(g.E());
        marked = new boolean[g.V()];
        mst = new Vector<>();

        visit(0);
        while (!pq.isEmpty()){
            //使用最小堆找出已经访问的边中权值最小的边
            Edge<Weight> e = pq.extractMin();
            //如果这条边的两端都已经访问过, 则扔掉这条边
            if(marked[e.V()] == marked[e.W()]){
                continue;
            }
            //否则, 这条边应该存在在最小生成树中
            mst.add(e);

            //访问和这条边连接的还没有被访问过的节点
            if(!marked[e.V()]){
                visit(e.V());
            }else{
                visit(e.W());
            }

            //计算最小生成树的权值
            mstWeight = mst.elementAt(0).wt();
            for (int i = 1; i < mst.size(); i++) {
                mstWeight = mstWeight.doubleValue() + mst.elementAt(i).wt().doubleValue();
            }
        }
    }

    /**
     * 返回最小生成树的所有边
     * @return
     */
    Vector<Edge<Weight>> mstEdges(){
        return mst;
    }

    /**
     * 返回最小生成树的权值
     * @return
     */
    Number result(){
        return mstWeight;
    }

    /**
     * 访问节点v
     * @param v
     */
    private void visit(int v) {
        assert !marked[v];

        marked[v] = true;
        //将和节点v相连的所有未访问的边放入最小堆中
        for (Edge<Weight> e : g.adj(v)) {
            if(!marked[e.other(v)]){
                pq.insert(e);
            }

        }
    }

}