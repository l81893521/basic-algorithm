package will.zhang.graphBasic.DDfsAndComponents;

/**
 * Created by Will.Zhang on 2018/1/30 0030 15:44.
 */
public class Main {

    public static void main(String[] args) {
        String fileName = Main.class.getClass().getResource("/graph").getPath() + "/testG1.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1, fileName);
        Components component1 = new Components(g1);
        System.out.println("TestG1.txt, Component Count: " + component1.count());
        System.out.println();

        fileName = Main.class.getClass().getResource("/graph").getPath() + "/testG2.txt";
        SparseGraph g2 = new SparseGraph(6, false);
        ReadGraph readGraph2 = new ReadGraph(g2, fileName);
        Components component2 = new Components(g2);
        System.out.println("TestG2.txt, Component Count: " + component2.count());

    }
}
