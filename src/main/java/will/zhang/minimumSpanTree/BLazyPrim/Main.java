package will.zhang.minimumSpanTree.BLazyPrim;

import java.util.Vector;

/**
 * Created by Will.Zhang on 2018/2/1 0001 12:26.
 */
public class Main {

    public static void main(String[] args) {
        String filename = Main.class.getClass().getResource("/graph").getPath() + "/testG3.txt";

        int V = 8;
        //测试最小生成树
        SparseWeightedGraph sparseWeightedGraph = new SparseWeightedGraph(V, false);
        ReadWeightedGraph readWeightedGraph = new ReadWeightedGraph(sparseWeightedGraph, filename);
        LazyPrimMST<Double> lazyPrimMST = new LazyPrimMST(sparseWeightedGraph);

        System.out.println("Test Lazy Prim MST:");
        Vector<Edge<Double>> mst = lazyPrimMST.mstEdges();
        for( int i = 0 ; i < mst.size() ; i ++ ){
            System.out.println(mst.elementAt(i));
        }
        System.out.println("The MST weight is: " + lazyPrimMST.result());


    }
}
