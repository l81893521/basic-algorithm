package will.zhang.graphBasic.CReadGraph;

/**
 * Created by Will.Zhang on 2018/1/30 0030 15:44.
 */
public class Main {

    public static void main(String[] args) {
        String fileName = Main.class.getClass().getResource("/graph").getPath() + "/testG1.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1, fileName);
        System.out.println("test G1 in Sparse Graph:");
        g1.show();

        System.out.println();

        DenseGraph g2 = new DenseGraph(13, false);
        ReadGraph readGraph2 = new ReadGraph(g2 , fileName);
        System.out.println("test G1 in Dense Graph:");
        g2.show();

        System.out.println();

        // 使用两种图的存储方式读取testG2.txt文件
        fileName = Main.class.getClass().getResource("/graph").getPath() + "/testG2.txt";
        SparseGraph g3 = new SparseGraph(6, false);
        ReadGraph readGraph3 = new ReadGraph(g3, fileName);
        System.out.println("test G2 in Sparse Graph:");
        g3.show();

        System.out.println();

        DenseGraph g4 = new DenseGraph(6, false);
        ReadGraph readGraph4 = new ReadGraph(g4, fileName);
        System.out.println("test G2 in Dense Graph:");
        g4.show();

    }
}
