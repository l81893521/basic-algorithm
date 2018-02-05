package will.zhang.minimumSpanTree.DKruskalAlgorithm;

import java.util.Vector;

/**
 * Created by Will.Zhang on 2018/2/5 0005 18:17.
 * kruskal算法求最小生成树
 */
public class KruskalMST<Weight extends Number & Comparable> {

    /**
     * 最小生成树包含的所有边
     */
    private Vector<Edge<Weight>> mst;
    /**
     * 最小生成树的权值
     */
    private Number mstWeight;

    public KruskalMST(WeightedGraph graph){
        mst = new Vector<>();

        //将图中所有边存放到一个最小堆中
        MinHeap<Edge<Weight>> pq = new MinHeap<>(graph.E());
        for (int i = 0; i < graph.V(); i++) {
            for (Object item : graph.adj(i)) {
                Edge<Weight> e = (Edge<Weight>) item;
                //点和点之间, 只会出现2条边, a到b和b到a, 只取其中一条
                if(e.V() < e.W()){
                    pq.insert(e);
                }
            }
        }

        //创建一个并查集, 来查看已经访问的节点的联通情况
        UnionFind uf = new UnionFind(graph.V());
        while(!pq.isEmpty() && mst.size() < graph.V() - 1){
            //从最小堆中依次从小到大取出所有边
            Edge<Weight> e = pq.extractMin();
            //如果该边的两个端点是联通的, 说明加入这条边将产生环, 扔掉这条边
            if(uf.isConnected(e.V(), e.W())){
                continue;
            }
            //否则, 将这条边添加进最小生成树, 同时标记边的两个端点联通
            mst.add(e);
            uf.union(e.V(), e.W());
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

    public static void main(String[] args) {
        String filename = KruskalMST.class.getClass().getResource("/graph").getPath() + "/testG3.txt";
        int V = 8;

        SparseWeightedGraph<Double> g = new SparseWeightedGraph<Double>(V, false);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);

        // Test Kruskal
        System.out.println("Test Kruskal:");
        KruskalMST<Double> kruskalMST = new KruskalMST<Double>(g);
        Vector<Edge<Double>> mst = kruskalMST.mstEdges();
        for( int i = 0 ; i < mst.size() ; i ++ )
            System.out.println(mst.elementAt(i));
        System.out.println("The MST weight is: " + kruskalMST.result());

        System.out.println();
    }
}
