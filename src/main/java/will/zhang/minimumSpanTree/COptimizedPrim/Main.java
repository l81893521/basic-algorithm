package will.zhang.minimumSpanTree.COptimizedPrim;

/**
 * Created by Will.Zhang on 2018/2/5 0005 15:27.
 */
public class Main {

    public static void main(String[] args) {
        String filename1 = Main.class.getClass().getResource("/graph").getPath() + "/testG4.txt";
        int V1 = 8;

        String filename2 = Main.class.getClass().getResource("/graph").getPath() + "/testG5.txt";
        int V2 = 250;

        String filename3 = Main.class.getClass().getResource("/graph").getPath() + "/testG6.txt";
        int V3 = 1000;

        String filename4 = Main.class.getClass().getResource("/graph").getPath() + "/testG7.txt";
        int V4 = 10000;

        //String filename5 = "testG5.txt";
        //int V5 = 1000000;


        // 文件读取
        SparseWeightedGraph<Double> g1 = new SparseWeightedGraph<Double>(V1, false);
        ReadWeightedGraph readGraph1 = new ReadWeightedGraph(g1, filename1);
        System.out.println( filename1 + " load successfully.");

        SparseWeightedGraph<Double> g2 = new SparseWeightedGraph<Double>(V2, false);
        ReadWeightedGraph readGraph2 = new ReadWeightedGraph(g2, filename2);
        System.out.println( filename2 + " load successfully.");

        SparseWeightedGraph<Double> g3 = new SparseWeightedGraph<Double>(V3, false);
        ReadWeightedGraph readGraph3 = new ReadWeightedGraph(g3, filename3);
        System.out.println( filename3 + " load successfully.");

        SparseWeightedGraph<Double> g4 = new SparseWeightedGraph<Double>(V4, false);
        ReadWeightedGraph readGraph4 = new ReadWeightedGraph(g4, filename4);
        System.out.println( filename4 + " load successfully.");

//        SparseWeightedGraph<Double> g5 = new SparseWeightedGraph<Double>(V5, false);
//        ReadWeightedGraph readGraph5 = new ReadWeightedGraph(g5, filename5);
//        System.out.println( filename5 + " load successfully.");

        System.out.println();


        long startTime, endTime;

        // Test Lazy Prim MST
        System.out.println("Test Lazy Prim MST:");

        startTime = System.currentTimeMillis();
        LazyPrimMST<Double> lazyPrimMST1 = new LazyPrimMST<Double>(g1);
        endTime = System.currentTimeMillis();
        System.out.println("Test for G1: " + (endTime-startTime) + "ms.");

        startTime = System.currentTimeMillis();
        LazyPrimMST<Double> lazyPrimMST2 = new LazyPrimMST<Double>(g2);
        endTime = System.currentTimeMillis();
        System.out.println("Test for G2: " + (endTime-startTime) + "ms.");

        startTime = System.currentTimeMillis();
        LazyPrimMST<Double> lazyPrimMST3 = new LazyPrimMST<Double>(g3);
        endTime = System.currentTimeMillis();
        System.out.println("Test for G3: " + (endTime-startTime) + "ms.");

        startTime = System.currentTimeMillis();
        LazyPrimMST<Double> lazyPrimMST4 = new LazyPrimMST<Double>(g4);
        endTime = System.currentTimeMillis();
        System.out.println("Test for G4: " + (endTime-startTime) + "ms.");

//        startTime = System.currentTimeMillis();
//        LazyPrimMST<Double> lazyPrimMST5 = new LazyPrimMST<Double>(g5);
//        endTime = System.currentTimeMillis();
//        System.out.println("Test for G5: " + (endTime-startTime) + "ms.");

        System.out.println();


        // Test Prim MST
        System.out.println("Test Prim MST:");

        startTime = System.currentTimeMillis();
        PrimMST<Double> primMST1 = new PrimMST<Double>(g1);
        endTime = System.currentTimeMillis();
        System.out.println("Test for G1: " + (endTime-startTime) + "ms.");

        startTime = System.currentTimeMillis();
        PrimMST<Double> primMST2 = new PrimMST<Double>(g2);
        endTime = System.currentTimeMillis();
        System.out.println("Test for G2: " + (endTime-startTime) + "ms.");

        startTime = System.currentTimeMillis();
        PrimMST<Double> primMST3 = new PrimMST<Double>(g3);
        endTime = System.currentTimeMillis();
        System.out.println("Test for G3: " + (endTime-startTime) + "ms.");

        startTime = System.currentTimeMillis();
        PrimMST<Double> primMST4 = new PrimMST<Double>(g4);
        endTime = System.currentTimeMillis();
        System.out.println("Test for G4: " + (endTime-startTime) + "ms.");

//        startTime = System.currentTimeMillis();
//        PrimMST<Double> primMST5 = new PrimMST<Double>(g5);
//        endTime = System.currentTimeMillis();
//        System.out.println("Test for G5: " + (endTime-startTime) + "ms.");

        System.out.println();
    }
}
