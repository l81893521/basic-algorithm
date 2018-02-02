package will.zhang.minimumSpanTree.AWeightedGraph;

/**
 * Created by Will.Zhang on 2018/2/1 0001 12:26.
 */
public class Main {

    public static void main(String[] args) {
        String filename = will.zhang.graphBasic.FBFSAndShortestPath.Main.class.getClass().getResource("/graph").getPath() + "/testG3.txt";

        SparseWeightedGraph sparseWeightedGraph = new SparseWeightedGraph(8, false);
        ReadWeightedGraph readWeightedGraph = new ReadWeightedGraph(sparseWeightedGraph, filename);
        System.out.println("test G1 in Sparse Weighted Graph:");
        sparseWeightedGraph.show();

        System.out.println();

        DenseWeightedGraph denseWeightedGraph = new DenseWeightedGraph(8, false);
        ReadWeightedGraph readWeightedGraph1 = new ReadWeightedGraph(denseWeightedGraph, filename);
        System.out.println("test G1 in Dense Graph:");
        denseWeightedGraph.show();

    }
}
